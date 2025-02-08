package patterns.monotonicstack.rangeQueries;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _2_SumOfSubarrayRanges {

    public static void main(String[] args) {
        int[] nums1 = {3, 1, 2, 4};
        int[] nums2 = {3, 1, 1, 2, 4};
        int[] nums3 = {71, 55, 82, 55};
        int[] nums4 = {2, 2, 2, 2};
        int[] nums5 = {1, 2, 3, 4};

        /*
         * Result=∑(max of all sub-arrays)−∑(min of all sub-arrays)
         */
        System.out.printf("%s, Output : %d\n", Arrays.toString(nums1), sumSubarrayExtremes(nums1, true) - sumSubarrayExtremes(nums1, false));
        System.out.printf("%s, Output : %d\n", Arrays.toString(nums2), sumSubarrayExtremes(nums2, true) - sumSubarrayExtremes(nums2, false));
        System.out.printf("%s, Output : %d\n", Arrays.toString(nums3), sumSubarrayExtremes(nums3, true) - sumSubarrayExtremes(nums3, false));
        System.out.printf("%s, Output : %d\n", Arrays.toString(nums4), sumSubarrayExtremes(nums4, true) - sumSubarrayExtremes(nums4, false));
        System.out.printf("%s, Output : %d\n", Arrays.toString(nums5), sumSubarrayExtremes(nums5, true) - sumSubarrayExtremes(nums5, false));
    }

    private static long sumSubarrayExtremes(int[] arr, boolean isMax) {
        Deque<Integer> stack = new ArrayDeque<>();
        long sum = 0;

        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty()) {
                boolean shouldPop = isMax ? arr[stack.peek()] <= arr[i] : arr[stack.peek()] >= arr[i];
                if (!shouldPop) break;
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                boolean shouldPop = isMax ? arr[stack.peek()] < arr[i] : arr[stack.peek()] > arr[i];
                if (!shouldPop) break;
                stack.pop();
            }
            right[i] = stack.isEmpty() ? arr.length - i : stack.peek() - i;
            stack.push(i);
        }

        for (int i = 0; i < arr.length; i++) {
            sum += (long) arr[i] * left[i] * right[i];
        }

        return sum;
    }
}
