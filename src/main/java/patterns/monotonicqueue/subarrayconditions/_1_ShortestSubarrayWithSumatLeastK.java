package patterns.monotonicqueue.subarrayconditions;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _1_ShortestSubarrayWithSumatLeastK {

    public static void main(String[] args) {
        int[] nums1 = {2, -1, 2, 3, -5, 4, 1};
        int[] nums2 = {2, -1, 2, 3, 6};
        int[] nums3 = {2, -1, 2, 3, -14, 6};
        int sum1 = 6;
        int[] nums4 = {-1, -2, -3};
        int sum2 = -6;
        System.out.printf("%s, target sum: %d, output : %d\n", Arrays.toString(nums1), sum1, getShortestSubarray(nums1, sum1));
        System.out.printf("%s, target sum: %d, output : %d\n", Arrays.toString(nums2), sum1, getShortestSubarray(nums2, sum1));
        System.out.printf("%s, target sum: %d, output : %d\n", Arrays.toString(nums3), sum1, getShortestSubarray(nums3, sum1));
        System.out.printf("%s, target sum: %d, output : %d\n", Arrays.toString(nums4), sum2, getShortestSubarray(nums4, sum2));
    }

    private static int getShortestSubarray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int minSubArrLen = Integer.MAX_VALUE;
        // The prefix sum array has an extra element to include a starting value of 0, simplifying sub-array sum calculations.
        long[] prefixSum = new long[nums.length + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        for (int i = 0; i < prefixSum.length; i++) {
            // Check if we can remove elements from the front to maintain sum >= k
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                minSubArrLen = Math.min(minSubArrLen, i - deque.pollFirst());
            }

            // Maintain a monotonic increasing order in the deque
            while (!deque.isEmpty() && prefixSum[deque.peekLast()] >= prefixSum[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return minSubArrLen == Integer.MAX_VALUE ? -1 : minSubArrLen;
    }
}
