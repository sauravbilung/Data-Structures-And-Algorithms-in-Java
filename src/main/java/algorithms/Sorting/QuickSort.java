package algorithms.Sorting;

import java.util.Arrays;

/**
 * Quicksort is a “divide and conquer” algorithm. The input list is divided into two sub-lists by an element called pivot; one sub-list
 * with elements less than the pivot and another one with elements greater than the pivot. This process repeats for each sub-list.
 * Finally, all sorted sub-lists merge to form the final output.
 *
 * Note : Quicksort isn’t a stable algorithm. A stable sorting algorithm is an algorithm where the elements with the same
 * values appear in the same order in the sorted output as they appear in the input list.
*/
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Given Array:");
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array:");
        System.out.println(Arrays.toString(arr));
    }


    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(arr, start, end);
            quickSort(arr, start, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int arr[], int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, ++i, end);
        return i;
    }

    private static void swap(int[] arr, int position1, int position2) {
        int temp = arr[position1];
        arr[position1] = arr[position2];
        arr[position2] = temp;
    }
}
