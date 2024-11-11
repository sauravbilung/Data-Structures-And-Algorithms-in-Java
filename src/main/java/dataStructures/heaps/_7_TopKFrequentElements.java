package dataStructures.heaps;

import java.util.*;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 */
public class _7_TopKFrequentElements {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4};
        int k = 2;
        System.out.printf("Output : %s ", Arrays.toString(topKFrequent(arr, k)));
    }

    private static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyCount = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : nums) {
            if (frequencyCount.containsKey(num)) {
                frequencyCount.put(num, frequencyCount.get(num) + 1);
            } else {
                frequencyCount.put(num, 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : frequencyCount.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }

        return result.stream().mapToInt(num -> num).toArray();
    }
}
