package algorithms.partitionalgorithms;


import java.util.Arrays;

/**
 * Partitions an array using the Lomuto partitioning scheme.
 * This algorithm selects a pivot (commonly the last element of the array)
 * and rearranges elements so that:
 * - Elements less than or equal to the pivot are on the left side.
 * - Elements greater than the pivot are on the right side.
 * <p>
 * Commonly used in basic implementations of Quicksort.
 * Note that Lomuto's partitioning is less efficient with arrays containing many duplicates,
 * as it may result in excessive swaps.
 */

public class LomutoPartitioning {
    public static void main(String[] args) {
        int[] arr = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 10, 32};
        System.out.printf("\n Original array : %s", Arrays.toString(arr));
        lomutoPartitioning(arr, 0, arr.length - 1);
        System.out.printf("\n After partitioning : %s", Arrays.toString(arr));
    }

    private static void lomutoPartitioning(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, ++i, high);
    }

    private static void swap(int[] arr, int position1, int position2) {
        int temp = arr[position1];
        arr[position1] = arr[position2];
        arr[position2] = temp;
    }
}
