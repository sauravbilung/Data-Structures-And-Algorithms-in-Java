package algorithms.partitionalgorithms;


import java.util.Arrays;

/**
 * Partitions an array using the Hoare partitioning scheme.
 * This algorithm selects a pivot (often the first element in the array)
 * and rearranges elements around the pivot as follows:
 * - Elements less than the pivot are moved to the left side.
 * - Elements greater than the pivot are moved to the right side.
 * <p>
 * Unlike Lomuto's partitioning, Hoare’s partitioning uses two pointers moving
 * from the ends of the array toward the center. The pointers stop when they find
 * elements that are on the wrong side of the pivot, and these elements are then swapped.
 * This approach requires fewer swaps on average, making it more efficient for arrays with
 * many duplicate values. However, the pivot does not necessarily end up at a fixed
 * position after partitioning, as it would with Lomuto's scheme.
 * <p>
 * After partitioning:
 * - The array is divided into two sections where elements on the left are less than
 * or equal to the pivot, and elements on the right are greater than or equal to the pivot.
 * - The returned partition index does not guarantee that the pivot itself is at this index;
 * rather, it marks the boundary between the two partitions.
 * <p>
 * This method is commonly used in optimized implementations of Quicksort.
 * <p>
 * Example:
 * <p>
 * Original array: [14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 10, 32]
 * Partition index: 4
 * After partitioning: [10, 5, 3, 4, 2, 54, 20, 87, 98, 20, 14, 32]
 * <p>
 * Explanation:
 * - Elements to the left of index 4 are less than or equal to the pivot (14),
 * while elements to the right are greater than or equal to it.
 * - The pivot itself may not be at the partition index.
 */

public class HoarePartitioning {
    public static void main(String[] args) {
        int[] arr = {14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 10, 32};
        System.out.printf("\nOriginal array: %s", Arrays.toString(arr));
        int partitionIndex = hoarePartitioning(arr, 0, arr.length - 1);
        System.out.printf("\nPartition index: %d", partitionIndex);
        System.out.printf("\nAfter partitioning: %s", Arrays.toString(arr));
    }

    /**
     * @param arr  The array to be partitioned.
     * @param low  The starting index of the array/subarray to be partitioned.
     * @param high The ending index of the array/subarray to be partitioned.
     * @return The index at which the partition is completed (may not be the exact pivot position).
     */
    private static int hoarePartitioning(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1, j = high + 1;
        while (true) {

            // Move 'i' right, stop when we find an element >= pivot
            do {
                i++;
            } while (arr[i] < pivot);

            // Move 'j' left, stop when we find an element <= pivot
            do {
                j--;
            } while (arr[j] > pivot);

            // If pointers have crossed, we return the partition point.
            if (i >= j)
                break;
            swap(arr, i, j);
        }
        return j;
    }

    private static void swap(int[] arr, int position1, int position2) {
        int temp = arr[position1];
        arr[position1] = arr[position2];
        arr[position2] = temp;
    }
}
