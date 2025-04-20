package dataStructures.map;

import java.util.*;

public class _2_LFUCache {

    public static void main(String[] args) {

        // LFU is based on frequency.
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 10); // freq=1
        lfu.put(2, 20); // freq=1
        lfu.get(1);     // freq(1)++
        lfu.put(3, 30); // evict key=2 (least frequent)

        System.out.println(lfu.get(1)); // 10
        System.out.println(lfu.get(2)); // -1
        System.out.println(lfu.get(3)); // 30
    }
}

class LFUCache {
    private static class Node {
        int key, value, freq;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private final int capacity;
    private int minFreq = 0;
    private final Map<Integer, Node> cache = new HashMap<>();
    private final Map<Integer, LinkedHashSet<Integer>> freqMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        updateFrequency(key);
        return cache.get(key).value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateFrequency(key);
        } else {
            if (cache.size() == capacity) {
                // Evict least frequent and least recently used
                int evictKey = freqMap.get(minFreq).iterator().next();
                freqMap.get(minFreq).remove(evictKey);
                cache.remove(evictKey);
            }

            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            freqMap.computeIfAbsent(1, f -> new LinkedHashSet<>()).add(key);
            minFreq = 1;
        }
    }

    private void updateFrequency(int key) {
        Node node = cache.get(key);
        int freq = node.freq;
        freqMap.get(freq).remove(key); // Removing from old frequency list

        // If I remove the last key from the current minFreq bucket, the new minFreq must be one level higher, otherwise eviction logic will break.
        if (freqMap.get(freq).isEmpty() && freq == minFreq) {
            minFreq++;
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, f -> new LinkedHashSet<>()).add(key);
    }
}