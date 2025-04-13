package algorithms.dynamicprogramming.knapsack.partitionEqualSubset;

import java.util.Arrays;

public class _1_LastStoneWeightII {

    public static void main(String[] args) {
        int[] stones1 = {3, 2, 1};   // Output should be 0 (split into [3] and [2,1])
        int[] stones2 = {1, 2, 5};   // Output should be 2 (split into [1,2] and [5])

        System.out.println("Minimum possible weight (stones1): " + lastStoneWeightII(stones1));
        System.out.println("Minimum possible weight (stones2): " + lastStoneWeightII(stones2));
    }

    public static int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int half = sum / 2;

        boolean[] dp = new boolean[half + 1];
        dp[0] = true;  // base case: sum 0 is always possible

        for (int stone : stones) {
            for (int j = half; j >= stone; j--) {
                dp[j] = dp[j] || dp[j - stone];
            }
        }

        // Find the closest possible subset sum to half
        for (int i = half; i >= 0; i--) {
            if (dp[i]) {
                int other = sum - i;
                return Math.abs(other - i);  // total - 2*i
            }
        }

        return 0; // fallback, should never be hit
    }
}
