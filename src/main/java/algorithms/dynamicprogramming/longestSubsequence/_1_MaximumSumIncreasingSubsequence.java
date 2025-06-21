package algorithms.dynamicprogramming.longestSubsequence;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Solves the Maximum Sum Increasing Subsequence (MSIS) problem using dynamic programming.
 * Given an integer array, it finds the maximum sum of any strictly increasing subsequence.
 * Strictly increasing: Each element in the sequence is greater than the previous.
 */

public class _1_MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        // input : int[] arr = {1, 101, 2, 3, 100, 4, 5};
        // output : 106 . 1 + 2 + 3 + 100 = 106;
        System.out.println("Enter space separated array contents : ");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(maxSumIS(nums, nums.length));
    }

    public static int maxSumIS(int[] arr, int n) {
        int[] maxSumArr = new int[n];
        maxSumArr[0] = arr[0];
        int globalMaxSum = arr[0];

        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int currentMaxSum = arr[i];
            while (j > -1) {
                if (arr[j] < arr[i] && (maxSumArr[j] + arr[i]) > currentMaxSum) {
                    currentMaxSum = maxSumArr[j] + arr[i];
                }
                j--;
            }
            maxSumArr[i] = currentMaxSum;
            if(globalMaxSum < maxSumArr[i]) {
                globalMaxSum = maxSumArr[i];
            }
        }
        return globalMaxSum;
    }
}
