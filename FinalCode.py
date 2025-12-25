import time
import threading
from concurrent.futures import ThreadPoolExecutor

class RateLimiter:
    def __init__(self):
        self.openai_rate_limit = 50  # 50 requests per minute
        self.gemini_rate_limit = 5   # 5 requests per second
        self.openai_time_window = 60  # 60 seconds
        self.gemini_time_window = 1  # 1 second
        self.cache = {
            'openai': {'timestamps': [], 'limit': self.openai_rate_limit},
            'gemini': {'timestamps': [], 'limit': self.gemini_rate_limit}
        }
        self.lock = threading.Lock()

    def _can_request(self, api_name):
        """ Checks if a request can be made to the given API based on its rate limit """
        current_time = time.time()
        api_info = self.cache[api_name]
        time_window = self.openai_time_window if api_name == 'openai' else self.gemini_time_window

        # Clean up old requests (timestamps that are outside the time window)
        api_info['timestamps'] = [timestamp for timestamp in api_info['timestamps'] if current_time - timestamp <= time_window]

        # Check if we can make a request
        if len(api_info['timestamps']) < api_info['limit']:
            return True
        else:
            return False

    def _register_request(self, api_name):
        """ Registers a request to the given API by adding the current time to its timestamps """
        current_time = time.time()
        self.cache[api_name]['timestamps'].append(current_time)

    def request_openai(self):
        """ Request to OpenAI, fallback to Gemini if rate limit reached """
        with self.lock:
            if self._can_request('openai'):
                self._register_request('openai')
                return "OpenAI request successful"
            else:
                # Fallback to Gemini if OpenAI is rate-limited
                if self._can_request('gemini'):
                    self._register_request('gemini')
                    return "Gemini request successful (OpenAI rate-limited)"
                else:
                    raise Exception("Rate Limit reached: Both OpenAI and Gemini have exceeded their limits")

    def request_gemini(self):
        """ Request to Gemini directly """
        with self.lock:
            if self._can_request('gemini'):
                self._register_request('gemini')
                return "Gemini request successful"
            else:
                raise Exception("Gemini Rate Limit reached: Too many requests in the last second")

    def reset(self):
        """ Reset the cache (for testing purposes or to manually reset rate limiter) """
        with self.lock:
            self.cache = {
                'openai': {'timestamps': [], 'limit': self.openai_rate_limit},
                'gemini': {'timestamps': [], 'limit': self.gemini_rate_limit}
            }

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