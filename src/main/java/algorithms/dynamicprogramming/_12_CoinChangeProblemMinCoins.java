package algorithms.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class _12_CoinChangeProblemMinCoins {

    static int[][] dp;

    public static void main(String[] args) {
        System.out.println("Enter space separated numbers : ");
        Scanner scanner = new Scanner(System.in);
        int[] coins = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Enter sum : ");
        int sum = scanner.nextInt();
        System.out.printf("Output : %d", minCoins(coins, sum));
    }

    private static int minCoins(int[] coins, int sum) {
        int size = coins.length;
        dp = new int[size + 1][sum + 1];

        int result = fetchMinCoins(coins, size, sum);
        return result == Integer.MAX_VALUE - 1 ? -1 : result;
    }

    /**
     * Code is backtracking the memoized table.
     */
    private static int fetchMinCoins(int[] coins, int i, int j) {

        if (j == 0) {
            dp[i][j] = 0;
        } else if (i == 0) {
            dp[i][j] = Integer.MAX_VALUE - 1;
        } else if (dp[i][j] != 0) {
            dp[i][j] = dp[i][j];
        } else {
            int includeCoin = coins[i - 1] <= j ? 1 + fetchMinCoins(coins, i, j - coins[i - 1]) : Integer.MAX_VALUE - 1;
            int excludeCoin = fetchMinCoins(coins, i - 1, j);
            dp[i][j] = Math.min(includeCoin, excludeCoin);
        }
        return dp[i][j];
    }
}
