package dataStructures.heaps;

import java.util.Arrays;

public class _4_ExtractMinKey {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 9, 1, 5, 6, 3, 8, 0, 10};
        HeapUtils.buildHeap(arr, HeapUtils.HeapType.MIN);

        System.out.println("Min array : ");
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));

        int heapSize = arr.length;
        System.out.printf("\nExtract min key : %d", HeapUtils.extractMin(arr, heapSize));
        heapSize--;

        System.out.println("\nMin heap after key extraction :");
        Arrays.stream(arr).limit(heapSize).forEach(num -> System.out.print(num + " "));
    }
}
