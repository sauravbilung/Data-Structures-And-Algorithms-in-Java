package patterns.fastAndSlowPointers.slidingwindowoptimization;

import java.util.Arrays;

public class _2_minimumsizesubarraysum {

    public static void main(String[] args) {
        int[][] nums = {{2, 3, 1, 2, 4, 3},
                {1, 4, 4},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 39, 5, 5, 1},
                {20, 30, 12, 5, 5, 3}};
        int[] targets = {7, 4, 11, 10, 10};

        for (int i = 0; i < nums.length; i++) {
            System.out.printf("Min subarray length for %s and target %d : %d\n", Arrays.toString(nums[i]), targets[i], minSubArrayLength(nums[i], targets[i]));
        }
    }

    private static int minSubArrayLength(int[] nums, int target) {
        int minWindowSize = Integer.MAX_VALUE, sum = 0;
        int windowStart = 0, windowEnd = 0;
        while (windowEnd < nums.length) {
            sum += nums[windowEnd];

            while (sum >= target) {
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                sum -= nums[windowStart++];
            }

            windowEnd++;
        }

        return minWindowSize == Integer.MAX_VALUE ? 0 : minWindowSize;
    }
}

