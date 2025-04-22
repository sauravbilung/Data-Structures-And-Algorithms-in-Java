package dataStructures.arrays;

import java.util.Arrays;

public class _1_RotateArrays {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        int k = 3;
        System.out.printf("Original Array : %s", Arrays.toString(nums));
        rotate(nums, k);
        System.out.printf("\nAfter rotation : %s", Arrays.toString(nums));
    }

    private static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k > n ? k % n : k;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // O(N^2) solution
    /*private static void rotateWorst(int[] nums, int k) {

        for (int i = 0; i < k; i++) {
            int temp = nums[0];
            nums[0] = nums[nums.length - 1];
            for (int j = 1; j < nums.length; j++) {
                nums[j] = nums[j] ^ temp;
                temp = nums[j] ^ temp;
                nums[j] = nums[j] ^ temp;
            }
        }
    }*/
}
