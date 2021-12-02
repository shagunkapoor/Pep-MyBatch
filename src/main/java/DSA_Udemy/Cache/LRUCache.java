package DSA_Udemy.Cache;

import java.util.LinkedHashMap;

public class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    int maxCapacity;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>();
        maxCapacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            //Make Recent
            int val = cache.remove(key);
            cache.put(key, val);
            return val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        //Condition is placed above so that in case of value override, previous value is not removed
        //eg: Cache ={[2,6], [1,5]}=> Put: [1,2]
        //Without this cond.=> 2,6 will be removed
        if (cache.containsKey(key)) {
            cache.remove(key);
        }

        while (cache.size() >= maxCapacity) {
            cache.remove(cache.keySet().iterator().next());
        }

        cache.put(key, value);
    }
}