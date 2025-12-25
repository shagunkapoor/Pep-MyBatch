import time
from collections import deque

class RateLimiter:
    def __init__(self):
        # OpenAI rate limit: 50 requests per minute
        self.openai_rate_limit = 50
        # Gemini rate limit: 5 requests per second
        self.gemini_rate_limit = 5

        # Time window configurations
        self.openai_time_window = 60  # 60 seconds
        self.gemini_time_window = 1   # 1 second

        # Caches (deques to store timestamps for each API)
        self.openai_cache = deque()
        self.gemini_cache = deque()

    def _can_request(self, cache, limit, time_window, current_time):
        """ Checks if we can make a request based on the rate limit """
        # Remove old timestamps that are outside the allowed time window
        while cache and current_time - cache[0] > time_window:
            cache.popleft()

        # If the number of requests in the time window is less than the limit, we can proceed
        return len(cache) < limit

    def _register_request(self, cache, current_time):
        """ Registers a new request by adding the current timestamp """
        cache.append(current_time)

    def request_openai(self):
        """ Request to OpenAI, fallback to Gemini if rate limit reached """
        current_time = time.time()

        if self._can_request(self.openai_cache, self.openai_rate_limit, self.openai_time_window, current_time):
            # Register the request to OpenAI
            self._register_request(self.openai_cache, current_time)
            return "OpenAI request successful"
        else:
            # Fallback to Gemini if OpenAI is rate-limited
            if self._can_request(self.gemini_cache, self.gemini_rate_limit, self.gemini_time_window, current_time):
                # Register the request to Gemini
                self._register_request(self.gemini_cache, current_time)
                return "Gemini request successful (OpenAI rate-limited)"
            else:
                raise Exception("Rate Limit reached: Both OpenAI and Gemini have exceeded their limits")

    def request_gemini(self):
        """ Request to Gemini directly """
        current_time = time.time()

        if self._can_request(self.gemini_cache, self.gemini_rate_limit, self.gemini_time_window, current_time):
            # Register the request to Gemini
            self._register_request(self.gemini_cache, current_time)
            return "Gemini request successful"
        else:
            raise Exception("Gemini Rate Limit reached: Too many requests in the last second")

    def reset(self):
        """ Reset the cache (for testing purposes or to manually reset rate limiter) """
        self.openai_cache.clear()
        self.gemini_cache.clear()

# Example Usage
rate_limiter = RateLimiter()

try:
    for _ in range(60):
        print(rate_limiter.request_openai())  # Should trigger OpenAI or Gemini if rate-limited

    # If the rate limit for both OpenAI and Gemini is reached, an exception will be raised
    print(rate_limiter.request_openai())  # This should raise an exception if both limits are exhausted

except Exception as e:
    print(str(e))
