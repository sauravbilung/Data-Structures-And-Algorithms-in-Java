package algorithms.greedy;

public class _2_JumpGameII {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        int result = jump(nums);
        System.out.println("Minimum jumps required to reach the end: " + result);
    }

    /**
     * This method returns the minimum number of jumps required to reach
     * the last index from the first index in the given array.
     *
     * @param nums - array where each element represents the max jump length at that position
     * @return minimum number of jumps to reach the end
     */
    public static int jump(int[] nums) {
        int n = nums.length;

        if (n <= 1) return 0;

        int jumps = 0;
        int maxReachableIdx = 0;     // The farthest index we can reach so far
        int currentReachableIdx = 0; // The farthest we can go with the current number of jumps

        // We go only till the second last index (n - 1)
        for (int i = 0; i < n - 1; i++) {
            // Update the farthest we can reach from index i
            maxReachableIdx = Math.max(maxReachableIdx, i + nums[i]);

            // If we've reached the limit of the current jump, it's time to jump and extend our reach
            if (i == currentReachableIdx) {
                jumps++;
                currentReachableIdx = maxReachableIdx;

                // Early exit if we can already reach or go beyond the last index
                if (currentReachableIdx >= n - 1) break;
            }
        }

        return jumps;
    }
}
