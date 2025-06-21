package algorithms.dynamicprogramming.longestSubsequence;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Finds the length of the Longest Increasing Subsequence (LIS) in an integer array
 * using dynamic programming with O(n²) time complexity.
 * An increasing subsequence means each next element is strictly greater than the previous one.
 */

public class _3_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        // input : int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        // output : 4. [2, 3, 7, 101] and [2, 5, 7, 18]
        System.out.println("Enter space separated array contents :");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.printf("Output : %d", lengthOfLIS(nums));
    }

    private static int lengthOfLIS(int[] nums) {
        int maxLengthOfLIS = 1;
        int[] lisTracker = new int[nums.length];
        lisTracker[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            lisTracker[i] = 1;
            for (int j = i - 1; j > -1; j--) {
                if (nums[j] < nums[i]) {
                    if (lisTracker[i] < lisTracker[j] + 1) {
                        lisTracker[i] = lisTracker[j] + 1;
                    }
                }
            }
            maxLengthOfLIS = Math.max(maxLengthOfLIS, lisTracker[i]);
        }
        return maxLengthOfLIS;
    }
}
