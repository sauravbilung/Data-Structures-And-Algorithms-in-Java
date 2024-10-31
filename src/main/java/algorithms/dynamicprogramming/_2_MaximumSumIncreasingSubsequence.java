package algorithms.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class _2_MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
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
