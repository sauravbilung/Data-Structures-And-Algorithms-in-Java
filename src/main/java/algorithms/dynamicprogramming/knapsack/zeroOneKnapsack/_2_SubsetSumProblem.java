package algorithms.dynamicprogramming.knapsack.zeroOneKnapsack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an array arr[] and a target sum, determine whether there exists a subset of the array that adds up exactly to the given sum.
 * */
public class _2_SubsetSumProblem {
    public static void main(String[] args) {
        System.out.println("Enter space separated array contents : ");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Enter sum : ");
        int sum = scanner.nextInt();
        System.out.printf("Subset with sum %d exists ? : %b", sum, isSubsetSum(nums, sum));
    }

    /**
     * Will fail for negative numbers and negative sum.
     */
    private static Boolean isSubsetSum(int[] arr, int sum) {
        int arrLength = arr.length;
        boolean[][] dp = new boolean[arrLength + 1][sum + 1];
        for (int i = 0; i < arrLength + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 && j != 0) {
                    dp[i][j] = false;
                } else if (j == 0 || (arr[i - 1] == j)) {
                    dp[i][j] = true;
                } else {
                    boolean isSumPossibleWhenCurrentNumberExcluded = dp[i - 1][j];
                    boolean isSumPossibleWhenCurrentNumberIncluded = arr[i - 1] < j && dp[i - 1][j - arr[i - 1]];
                    dp[i][j] = isSumPossibleWhenCurrentNumberIncluded || isSumPossibleWhenCurrentNumberExcluded;
                }
            }
        }
        return dp[arrLength][sum];
    }
}
