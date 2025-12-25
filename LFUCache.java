package DSA_Udemy.Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

//An LFU cache is an algorithm for managing cache data where the least frequently used
//entries are removed first.
//Different from an LRU (Least Recently Used) cache, where the oldest entries are removed first.
public class LFUCache {
    int maxCapacity;

    //stores the actual key-value pairs of the cache
    Map<Integer, Integer> cache = new HashMap<>();

    //keeps track of the frequency of access of each key in the cache
    Map<Integer, Integer> keycount = new HashMap<>();

    //maps a frequency count to a set of keys that have been accessed that many times. It's used to quickly find keys to evict when the cache is full.
    Map<Integer, LinkedHashSet<Integer>> freqmap = new HashMap<>();
    int min = -1;

    public LFUCache(int capacity) {
        maxCapacity = capacity;
        freqmap.put(1, new LinkedHashSet<>());
    }

    //O(1)
    public int get(int key) {
        if (cache.containsKey(key) == false)
            return -1;
        int count = keycount.get(key);
        keycount.put(key, count + 1);
        freqmap.get(count).remove(key);
        if (count == min && freqmap.get(count).size() == 0)
            min++;
        if (freqmap.containsKey(count + 1) == false)
            freqmap.put(count + 1, new LinkedHashSet<>());
        freqmap.get(count + 1).add(key);
        return cache.get(key);
    }

    //O(1)
    public void put(int key, int value) {
        if (maxCapacity <= 0)
            return;
        if (cache.containsKey(key)) {
            cache.put(key, value);
            get(key);
            return;
        }
        if (cache.size() >= maxCapacity) {
            int evict = freqmap.get(min).iterator().next();
            freqmap.get(min).remove(evict);
            cache.remove(evict);
            keycount.remove(evict);
        }
        cache.put(key, value);
        keycount.put(key, 1);
        min = 1;
        freqmap.get(1).add(key);

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */