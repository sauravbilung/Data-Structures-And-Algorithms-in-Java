package algorithms.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The goal is to find a contiguous subarray within the larger array that yields the largest sum.
 * The key point is that the subarray must be contiguous (meaning the elements of the subarray are consecutive within the original array).
 *
 * Kadane's Algorithm :
 * Key concept : At each step, we decide whether to extend the current subarray by adding the next element or to start a new subarray from the current element.
 */
public class _1_MaximumSumSubarray {
    public static void main(String[] args) {
        System.out.println("Enter the array contents :");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0], currentSum = nums[0];
        for (int i = 1 ; i < nums.length; i++) {
            // Choose between extending or starting a new subarray
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
