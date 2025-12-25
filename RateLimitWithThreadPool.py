import time
from collections import deque
from concurrent.futures import ThreadPoolExecutor
import threading

class RateLimiter:
    def __init__(self):
        # Rate limits
        self.openai_rate_limit = 50  # 50 requests per minute (60 seconds)
        self.gemini_rate_limit = 5   # 5 requests per second

        # Time window sizes
        self.openai_time_window = 60  # OpenAI: 60 seconds window
        self.gemini_time_window = 1   # Gemini: 1 second window

        # Caches (deques for storing timestamps of requests)
        self.openai_cache = deque()
        self.gemini_cache = deque()

        # Lock to protect rate limit cache access
        self.lock = threading.Lock()

    def _can_request(self, cache, limit, time_window, current_time):
        """Check if a new request can be made within the rate limit"""
        # Remove old timestamps that are outside the allowed time window
        while cache and current_time - cache[0] > time_window:
            cache.popleft()

        # If the number of requests in the time window is less than the limit, we can proceed
        return len(cache) < limit

    def _register_request(self, cache, current_time):
        """Register a request by adding the current timestamp to the cache"""
        cache.append(current_time)

    def request_openai(self):
        """Request to OpenAI, fallback to Gemini if OpenAI limit is reached"""
        current_time = time.time()

        with self.lock:  # Ensure thread-safety while accessing rate limit cache
            if self._can_request(self.openai_cache, self.openai_rate_limit, self.openai_time_window, current_time):
                # Register the request to OpenAI
                self._register_request(self.openai_cache, current_time)
                return "OpenAI request successful"
            else:
                # If OpenAI is rate-limited, try Gemini
                if self._can_request(self.gemini_cache, self.gemini_rate_limit, self.gemini_time_window, current_time):
                    # Register the request to Gemini
                    self._register_request(self.gemini_cache, current_time)
                    return "Gemini request successful (OpenAI rate-limited)"
                else:
                    # If both OpenAI and Gemini are rate-limited
                    raise Exception("Rate Limit reached: Both OpenAI and Gemini have exceeded their limits")

    def request_gemini(self):
        """Request to Gemini directly"""
        current_time = time.time()

        with self.lock:  # Ensure thread-safety while accessing rate limit cache
            if self._can_request(self.gemini_cache, self.gemini_rate_limit, self.gemini_time_window, current_time):
                # Register the request to Gemini
                self._register_request(self.gemini_cache, current_time)
                return "Gemini request successful"
            else:
                raise Exception("Gemini Rate Limit reached: Too many requests in the last second")

    def reset(self):
        """Reset the rate limiter cache (useful for testing or manually resetting)"""
        with self.lock:
            self.openai_cache.clear()
            self.gemini_cache.clear()

# Function to simulate making requests using ThreadPoolExecutor
def simulate_request(rate_limiter, request_type):
    try:
        if request_type == 'openai':
            print(rate_limiter.request_openai())
        else:
            print(rate_limiter.request_gemini())
    except Exception as e:
        print(f"Error: {str(e)}")

# Example Usage with ThreadPoolExecutor
if __name__ == "__main__":
    rate_limiter = RateLimiter()

    # Simulate concurrent requests with ThreadPoolExecutor
    with ThreadPoolExecutor(max_workers=10) as executor:
        # Simulate 30 requests to OpenAI and 20 to Gemini
        futures = []
        for _ in range(30):
            futures.append(executor.submit(simulate_request, rate_limiter, 'openai'))

        for _ in range(20):
            futures.append(executor.submit(simulate_request, rate_limiter, 'gemini'))

        # Wait for all tasks to complete
        for future in futures:
            future.result()  # Block until all requests are processed
