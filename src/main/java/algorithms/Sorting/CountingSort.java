package algorithms.Sorting;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] nums = {4, 2, 2, 8, 3, 3, 1};
        int[] sorted = countingSort(nums);
        System.out.println(Arrays.toString(sorted));
    }

    private static int[] countingSort(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt(); // Find the maximum value in the array
        int[] count = new int[max + 1]; // Create count array of size (max + 1)

        // Step 1: Count frequency of each element
        for (int num : nums) {
            count[num]++;
        }

        // Step 2: Compute prefix sums to get actual positions
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Build output array (iterate in reverse for stability)
        int[] output = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            output[count[num] - 1] = num; // Place the element at its correct position
            count[num]--; // Decrement count to handle duplicates.
        }

        return output;
    }
}
