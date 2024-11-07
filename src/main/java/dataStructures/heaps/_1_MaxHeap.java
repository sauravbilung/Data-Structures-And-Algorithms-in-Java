package dataStructures.heaps;

import java.util.Arrays;

public class _1_MaxHeap {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 9, 1, 5, 6, 3, 8, 0, 10};
        System.out.println("Original array : ");
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));

        HeapUtils.buildHeap(arr, HeapUtils.HeapType.MAX);

        System.out.println("\nMax heap array : ");
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
    }

}
