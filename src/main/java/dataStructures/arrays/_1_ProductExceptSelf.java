package dataStructures.arrays;

import java.util.Arrays;

public class _1_ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ProductExceptSelfSolution solution = new ProductExceptSelfSolution();
        System.out.println(Arrays.toString(solution.productExceptSelf(nums)));
    }
}

class ProductExceptSelfSolution {

    // Space optimised solution
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] output = new int[n];

        output[0] = 1;
        // Computing prefix product
        for (int i = 1; i < n; i++) {
            output[i] = nums[i - 1] * output[i - 1];

        }

        // Computing suffic product
        int suffixProduct = 1;

        for (int i = n - 1; i >= 0; i--) {
            output[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return output;
    }

    public int[] productExceptSelf2(int[] nums) {

        int n = nums.length;

        int[] left = new int[n]; // prefix product
        int[] right = new int[n]; // suffix product
        int[] output = new int[n];

        left[0] = 1;
        right[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = nums[i - 1] * left[i - 1];
            right[n - 1 - i] = nums[n - i] * right[n - i];
        }

        for (int i = 0; i < n; i++) {
            output[i] = left[i] * right[i];
        }

        return output;
    }
}
