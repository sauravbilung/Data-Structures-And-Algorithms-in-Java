package dataStructures.heaps;

import java.util.Arrays;

public class _5_Increase_Key {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 9, 1, 5, 6, 3, 8, 0, 10};
        HeapUtils.buildHeap(arr, HeapUtils.HeapType.MAX);

        System.out.println("Max heap : ");
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));

        HeapUtils.maxHeapIncreaseKey(arr, 8, 11);

        System.out.println("\nUpdated max heap :");
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
    }
}
