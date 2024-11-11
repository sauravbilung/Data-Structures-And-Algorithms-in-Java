package algorithms.dynamicprogramming;

import java.util.Scanner;

/**
 * Problem link : https://www.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
 * */
public class _9_CountAllNbitIntegersWithNoConsecutiveZeros {
    public static void main(String[] args) {
        System.out.println("Enter string length : ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.printf("Output : %d", countStrings(n));
    }

    private static long countStrings(int n) {
        long[] numberOfStrings = new long[n + 1];
        int mod = 1000000007;

        if (n == 1) {
            return 2;
        } else if (n == 2) {
            return 3;
        } else {
            numberOfStrings[1] = 2;
            numberOfStrings[2] = 3;
            for (int i = 3; i < n + 1; i++) {
                numberOfStrings[i] = (numberOfStrings[i - 1] + numberOfStrings[i - 2]) % mod;
            }
        }
        return numberOfStrings[n];
    }
}
