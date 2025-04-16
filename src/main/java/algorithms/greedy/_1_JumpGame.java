package algorithms.greedy;

import java.util.Arrays;

public class _1_JumpGame {

    public static void main(String[] args) {
        int[] nums = {4, 2, 0, 0, 1, 1, 4, 4, 4, 0, 4, 0};
        int[] nums2 = {2, 0, 0, 0};

        System.out.printf("%s reachable : %b", Arrays.toString(nums), isReachable(nums));
        System.out.printf("\n%s reachable : %b", Arrays.toString(nums2), isReachable(nums2));
    }

    /**
     * Determines if it is possible to reach the last index of the array starting from the first index.
     * Each element in the array represents the maximum number of steps that can be jumped forward from that index.
     *
     * This uses a greedy approach where we maintain the furthest index reachable so far.
     * If at any point, the current index is beyond this maximum reachable index, return false.
     *
     * @param nums An array of non-negative integers where each element represents the maximum jump length at that position.
     * @return true if the last index is reachable, false otherwise.
     */
    private static boolean isReachable(int[] nums) {
        int maxReachableIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReachableIdx) return false;
            maxReachableIdx = Math.max(maxReachableIdx, i + nums[i]);
        }
        return true;
    }
}
