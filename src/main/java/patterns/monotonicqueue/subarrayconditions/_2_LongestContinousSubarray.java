package patterns.monotonicqueue.subarrayconditions;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 */
public class _2_LongestContinousSubarray {

    public static void main(String[] args) {
        int[] nums1 = {8, 2, 4, 7};
        int limit1 = 4;
        int[] nums2 = {10, 1, 2, 4, 7, 2};
        int limit2 = 5;
        int[] nums3 = {1,5,9};
        int limit3 = 1;
        System.out.printf("%s, limit = %d, output = %d\n", Arrays.toString(nums1), limit1, getLongestSubArray(nums1, limit1));
        System.out.printf("%s, limit = %d, output = %d\n", Arrays.toString(nums2), limit2, getLongestSubArray(nums2, limit2));
        System.out.printf("%s, limit = %d, output = %d\n", Arrays.toString(nums3), limit3, getLongestSubArray(nums3, limit3));
    }

    private static int getLongestSubArray(int[] nums, int limit) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Deque<Integer> minDeque = new ArrayDeque<>(); // increasing deque
        Deque<Integer> maxDeque = new ArrayDeque<>(); // decreasing deque
        int windowStart = 0, maxWindowSize = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {

            // Maintain decreasing order
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[windowEnd]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(windowEnd);

            // Maintain increasing order
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[windowEnd]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(windowEnd);

            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                if (maxDeque.peekFirst() == windowStart) maxDeque.pollFirst();
                if (minDeque.peekFirst() == windowStart) minDeque.pollFirst();
                windowStart++;
            }

            maxWindowSize = Math.max(maxWindowSize, windowEnd - windowStart + 1);
        }

        return maxWindowSize;
    }
}
