package algorithms.dynamicprogramming.knapsack.zeroOneKnapsack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an array arr[] and a target sum, determine whether there exists a subset of the array that adds up exactly to the given sum.
 */
public class _2_SubsetSumProblem {
    public static void main(String[] args) {
        System.out.println("Enter space separated array contents : ");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Enter sum : ");
        int sum = scanner.nextInt();
        System.out.printf("Subset with sum %d exists ? : %b", sum, isSubsetSum(nums, sum));
    }

    private static Boolean isSubsetSumSpaceOptimised(int[] arr, int sum) {
        boolean[] dp = new boolean[sum + 1];

        dp[0] = true;

        for (int num : arr) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[sum];
    }

    /**
     * Will fail for negative numbers and negative sum.
     */
    private static Boolean isSubsetSum(int[] arr, int sum) {
        int arrLength = arr.length;
        boolean[][] dp = new boolean[arrLength + 1][sum + 1];

        for (int i = 0; i <= arrLength; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= arrLength; i++) {
            for (int j = 1; j <= sum; j++) {
                boolean isSumPossibleWhenCurrentNumberExcluded = dp[i - 1][j];
                boolean isSumPossibleWhenCurrentNumberIncluded = arr[i - 1] <= j && dp[i - 1][j - arr[i - 1]];
                dp[i][j] = isSumPossibleWhenCurrentNumberIncluded || isSumPossibleWhenCurrentNumberExcluded;
            }
        }

        return dp[arrLength][sum];
    }
}
