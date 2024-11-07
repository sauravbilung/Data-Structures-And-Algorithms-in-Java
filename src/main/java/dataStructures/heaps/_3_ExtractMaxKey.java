package dataStructures.heaps;

import java.util.Arrays;

public class _3_ExtractMaxKey {
    
    public static void main(String[] args) {
        int[] arr = new int[]{3, 9, 1, 5, 6, 3, 8, 0, 10};
        HeapUtils.buildHeap(arr, HeapUtils.HeapType.MAX);
        System.out.println("Max heap : ");
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
        int heapSize = arr.length;

        System.out.printf("\nMax key from heap : %d", HeapUtils.extractMax(arr, heapSize));
        heapSize--;

        System.out.println("\nMax heap after key extraction : ");
        Arrays.stream(arr).limit(heapSize).forEach(num -> System.out.print(num + " "));
    }
}
