package dataStructures.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class _1_LRUCache {

    public static void main(String[] args) {
        // LRU is based on recency
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.get(1);           // Access 1 (now 2 is LRU)
        cache.put(4, "D");      // Evicts 2
        System.out.println(cache); // Output: {3=C, 1=A, 4=D}

    }
}

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // access-order = true
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // It is called after put() method.
        // It tells the LinkedHashMap when to remove the "eldest" entry.
        return size() > capacity;
    }
}

