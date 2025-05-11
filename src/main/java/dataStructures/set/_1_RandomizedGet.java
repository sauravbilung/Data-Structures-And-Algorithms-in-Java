package dataStructures.set;

import java.util.*;

public class _1_RandomizedGet {

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.insert(10)); // true
        System.out.println(set.insert(20)); // true
        System.out.println(set.insert(30)); // true
        System.out.println(set.remove(20)); // true
        System.out.println(set.getRandom());
    }
}

/**
 * RandomizedSet supports O(1) insertion, deletion, and random retrieval of elements.
 * It does not allow duplicate values.
 *
 * Internally, it uses:
 * - A HashMap to store the value-to-index mapping.
 * - A List to store the values in sequence.
 * - A Random instance to retrieve elements randomly.
 *
 * This structure ensures all operations run in constant time.
 */
class RandomizedSet {

    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(index, lastElement);
        map.put(lastElement, index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIdx = random.nextInt(list.size());
        return list.get(randomIdx);
    }
}