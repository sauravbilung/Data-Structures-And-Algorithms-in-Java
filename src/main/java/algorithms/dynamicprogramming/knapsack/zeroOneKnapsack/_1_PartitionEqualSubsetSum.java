package algorithms.dynamicprogramming.knapsack.zeroOneKnapsack;

import java.util.Arrays;

/**
 * Given a non-empty array nums containing positive integers, determine if it can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.
 * */
public class _1_PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums1 = {1, 5, 11, 5};
        int[] nums2 = {1, 2, 3, 5};

        System.out.println("Can partition nums1 ? " + canPartitionSpaceOptimised(nums1)); // true
        System.out.println("Can partition nums2 ? " + canPartitionSpaceOptimised(nums2)); // false
    }


    public static boolean canPartitionSpaceOptimised(int[] nums) {

        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) return false;

        int half = sum / 2;

        boolean[] dp = new boolean[half + 1];
        dp[0] = true;

        // We are updating the dp array in reverse to ensure we are still using the results from the previous "row".
        // (previous item's state)
        for (int num : nums) {
            for (int j = half; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[half];
    }

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) return false;

        int half = sum / 2;
        int n = nums.length;

        // dp[i][j] means: is it possible to form sum j using first i elements
        boolean[][] dp = new boolean[n + 1][half + 1];

        // A sum of 0 is always possible (by picking no elements)
        for (int i = 0; i <= n; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= half; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j]; // skip current element
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]]; // take or skip
                }

                // Optional: early return if we've already found the subset
                if (j == half && dp[i][j]) return true;
            }
        }

        return dp[n][half];
    }
}
