package algorithms.dynamicprogramming.knapsack.unboundedKnapsack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Solves the Coin Change Problem (Count Ways variant) using dynamic programming.
 * Given unlimited supply of coins, it calculates the number of ways to make a target sum.
 */
public class _1_CoinChangeProblemCountWays {
    public static void main(String[] args) {
        System.out.println("Enter space separated numbers : ");
        Scanner scanner = new Scanner(System.in);
        int[] coins = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Enter sum : ");
        int sum = scanner.nextInt();
        System.out.printf("Output : %d", count(coins, sum));
    }

    private static long count(int[] coins, int sum) {
        long[][] noOfWays = new long[coins.length + 1][sum + 1];
        for (int i = 0; i < coins.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (j == 0) {
                    noOfWays[i][j] = 1;
                }
                if (i > 0 && coins[i - 1] <= j) {
                    noOfWays[i][j] = noOfWays[i][j - coins[i - 1]] + noOfWays[i - 1][j];
                }

                if (i > 0 && coins[i - 1] > j) {
                    noOfWays[i][j] = noOfWays[i - 1][j];
                }
            }
        }
        return noOfWays[coins.length][sum];
    }
}
