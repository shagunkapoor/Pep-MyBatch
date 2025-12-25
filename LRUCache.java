package DSA_Udemy.Cache;

import java.util.LinkedHashMap;

//The best data structure to use for creating an LRU (Least Recently Used) cache
// is a combination of a Hashmap and a Doubly Linked List.
// The Hashmap provides O(1) access to keys and
// the Doubly Linked List allows O(1) addition and removal of nodes, making it an ideal data structure for LRU Cache.
// In Java, you can use the LinkedHashMap class which is a HashTable and Doubly LinkedList implementation of the Map interface,
// with predictable iteration order.
// This implementation differs from HashMap in that it maintains a doubly-linked list running through all of its entries.
// This linked list defines the iteration ordering, which is normally the order in which keys were inserted into the map (insertion-order).

public class LRUCache {
    //Hash Table + Doubly Linked List
    //Maintains insertion order
    LinkedHashMap<Integer, Integer> cache;
    int maxCapacity;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>();
        maxCapacity = capacity;
    }

    //O(1)
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

    //O(1)
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