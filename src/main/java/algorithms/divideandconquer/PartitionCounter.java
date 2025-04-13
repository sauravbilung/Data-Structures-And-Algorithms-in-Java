package algorithms.divideandconquer;

import java.util.Arrays;

/**
 * The PartitionCounter class recursively counts how many times an array
 * can be split into two equal-sum halves, where each split must occur
 * exactly at the middle of the current subarray.
 *
 * The process continues recursively for each half as long as the two halves
 * have equal sums and are divisible at the midpoint.
 *
 * Example:
 * Input: [8, 0, 0, 0, 2, 2, 2, 2]
 * Splits:
 * 1. [8, 0, 0, 0] | [2, 2, 2, 2]
 * 2. [2, 2] | [2, 2]
 * 3. [2] | [2]
 * Total splits = 3
 */
public class PartitionCounter {

    public static void main(String... args) {
        int[] nums1 = {8, 0, 0, 0, 2, 2, 2, 2};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] nums3 = {3, 3, 3, 3, 3, 3, 3, 3};
        System.out.printf("%s : Partition count : %d", Arrays.toString(nums1), getPartitionCount(nums1, 0, nums1.length - 1));
        System.out.printf("\n%s : Partition count : %d", Arrays.toString(nums2), getPartitionCount(nums2, 0, nums2.length - 1));
        System.out.printf("\n%s : Partition count : %d", Arrays.toString(nums3), getPartitionCount(nums3, 0, nums3.length - 1));
    }

    private static int getPartitionCount(int[] arr, int start, int end) {
        if (start >= end) return 0;

        int mid = (start + end) / 2;

        int leftSum = sum(arr, start, mid);
        int rightSum = sum(arr, mid + 1, end);

        if (leftSum == rightSum) {
            // Valid split at the middle, now recursively check both halves
            int leftCount = getPartitionCount(arr, start, mid);
            int rightCount = getPartitionCount(arr, mid + 1, end);
            return 1 + leftCount + rightCount;
        }

        return 0; // No valid split at the midpoint
    }

    private static int sum(int[] arr, int start, int end) {
        int total = 0;
        for (int i = start; i <= end; i++) total += arr[i];
        return total;
    }
}
