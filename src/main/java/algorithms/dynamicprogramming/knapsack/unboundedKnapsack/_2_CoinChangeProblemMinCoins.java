package algorithms.dynamicprogramming.knapsack.unboundedKnapsack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Solves the Coin Change Problem (Min Coins variant) using memoization (top-down DP).
 * Finds the minimum number of coins required to make a target sum using unlimited supply of coins.
 */
public class _2_CoinChangeProblemMinCoins {

    public static void main(String[] args) {
        System.out.println("Enter space separated numbers : ");
        Scanner scanner = new Scanner(System.in);
        int[] coins = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Enter sum : ");
        int sum = scanner.nextInt();
        System.out.printf("Output : %d", minCoins(coins, sum));
    }

    private static int minCoins(int[] coins, int sum) {

        if (sum <= 0 || coins == null || coins.length == 0) {
            System.out.println("Invalid inputs.");
            return -1;
        }

        //int result = fetchMinCoins(coins, coins.length, sum, new int[coins.length + 1][sum + 1]);
        int result = fetchMinCoinsSpaceOptimised(coins, sum);
        return result == Integer.MAX_VALUE - 1 ? -1 : result;
    }

    /**
     * Code is backtracking the memoized table. Top-Down approach
     */
    private static int fetchMinCoins(int[] coins, int i, int j, int[][] dp) {

        if (i == 0) {
            dp[i][j] = j == 0 ? 0 : Integer.MAX_VALUE - 1;
        } else if (dp[i][j] != 0) {
            return dp[i][j];
        } else {
            int includeCoin = coins[i - 1] <= j ? 1 + fetchMinCoins(coins, i, j - coins[i - 1], dp) : Integer.MAX_VALUE - 1;
            int excludeCoin = fetchMinCoins(coins, i - 1, j, dp);
            dp[i][j] = Math.min(includeCoin, excludeCoin);
        }
        return dp[i][j];
    }

    /**
     * Bottom-up approach. Space optimized.
     **/
    private static int fetchMinCoinsSpaceOptimised(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= sum; i++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return dp[sum];
    }
}
