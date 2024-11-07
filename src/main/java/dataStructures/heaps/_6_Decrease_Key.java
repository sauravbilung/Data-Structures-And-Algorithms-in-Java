package dataStructures.heaps;

import java.util.Arrays;

public class _6_Decrease_Key {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 9, 1, 5, 6, 3, 8, 0, 10};
        HeapUtils.buildHeap(arr, HeapUtils.HeapType.MIN);

        System.out.println("Min heap : ");
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));

        HeapUtils.minHeapDecreaseKey(arr, 8, 2);

        System.out.println("\nUpdated min heap :");
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
    }
}
