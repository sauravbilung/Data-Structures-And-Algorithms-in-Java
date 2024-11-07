package algorithms.Sorting;

import dataStructures.heaps.HeapUtils;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{11, 7, 3, 0, 7, 9, 1, 5, 0};
        System.out.println("Given array:");
        System.out.println(Arrays.toString(arr));

        heapSort(arr);

        System.out.println("Sorted array");
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        HeapUtils.buildHeap(arr, HeapUtils.HeapType.MAX);
        System.out.println("Max Heap : " + Arrays.toString(arr));
        int heapSize = arr.length;
        for (int i = heapSize - 1; i > 0; i--) {
            HeapUtils.swap(arr, 0, i);
            // condition is i < heapSize so if i is 6 it will consider heap till element at 5th position.
            HeapUtils.maxHeapify(arr, 0, i);
        }
    }
}
