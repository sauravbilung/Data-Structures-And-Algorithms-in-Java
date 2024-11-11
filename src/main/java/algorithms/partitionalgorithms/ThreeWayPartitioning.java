package algorithms.partitionalgorithms;

import java.util.Arrays;

/**
 * Performs three-way partitioning on an array based on a specified pivot range.
 * Elements are rearranged in the array to satisfy the following conditions:
 * - Elements less than the lower bound of the pivot range appear at the start,
 * - Elements within the pivot range appear in the middle,
 * - Elements greater than the upper bound of the pivot range appear at the end.
 * <p>
 * This algorithm is useful for handling arrays with duplicate values efficiently
 * and is commonly used in problems such as the Dutch National Flag problem and
 * optimized versions of Quicksort.
 * </p>
 * <p>
 * Example:
 * Given an array {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 10, 32} and range [10, 20],
 * the resulting partitioned array might be arranged as [1, 5, 4, 2, 3, 14, 20, 20, 10, 54, 87, 98, 32],
 * where elements < 10 are at the start, elements within [10, 20] in the middle, and elements > 20 at the end.
 * </p>
 */
public class ThreeWayPartitioning {
    public static void main(String[] args) {
        int[] arr = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 10, 32};
        int lowerBound = 10; // Range start inclusive
        int upperBound = 20; // Range end inclusive
        System.out.printf("Original array : %s", Arrays.toString(arr));
        threewaypartition(arr, lowerBound, upperBound);
        System.out.printf("\n Three way partitioned array : %s", Arrays.toString(arr));
    }

    private static void threewaypartition(int[] arr, int lowerBound, int upperBound) {
        int size = arr.length;
        int low = 0, high = size - 1;
        for (int i = 0; i <= high; i++) {
            if (arr[i] < lowerBound) {
                swap(arr, i, low);
                low++;
            } else if (arr[i] > upperBound) {
                swap(arr, i, high);
                high--;
                i--;
            }
        }
    }

    private static void swap(int[] arr, int position1, int position2) {
        int temp = arr[position1];
        arr[position1] = arr[position2];
        arr[position2] = temp;
    }
}
