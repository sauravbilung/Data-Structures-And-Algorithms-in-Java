package algorithms.Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapSortUsingPriorityQueue {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 9, 1, 5, 6, 3, 8, 0, 10};

        System.out.println("Original array");
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));

        heapSort(arr);
        System.out.println("\nSorted array ascending");
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));

        heapSort(arr, false);
        System.out.println("\n Sorted array descending");
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
    }

    private static void heapSort(int[] arr) {
        heapSort(arr, true);
    }

    private static void heapSort(int[] arr, boolean isAscending) {

        PriorityQueue<Integer> heap = isAscending ? new PriorityQueue<>() : new PriorityQueue<>(Comparator.reverseOrder());

        //maxHeap.addAll(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)));
        for (int num : arr) {
            heap.add(num);
        }

        int index = 0;
        while (!heap.isEmpty()) {
            arr[index++] = heap.poll();
        }
    }
}
