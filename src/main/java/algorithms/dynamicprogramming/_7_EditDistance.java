package algorithms.dynamicprogramming;

import java.util.Scanner;

public class _7_EditDistance {

    public static void main(String[] args) {
        System.out.println("Enter first word : ");
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine();
        System.out.println("Enter second word : ");
        String word2 = scanner.nextLine();
        System.out.printf("Edit Distance : %d ", minDistance(word1, word2));
    }

    private static int minDistance(String word1, String word2) {
        int word1Len = word1.length(), word2Len = word2.length();
        int[][] editDistance = new int[word1Len + 1][word2Len + 1];

        for (int i = 0; i <= word1Len; i++) {
            for (int j = 0; j <= word2Len; j++) {

                if (i == 0 || j == 0) {
                    editDistance[i][j] = j == 0 ? i : j;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    editDistance[i][j] = editDistance[i - 1][j - 1];
                } else {
                    editDistance[i][j] = 1 + minimum(editDistance[i - 1][j - 1], editDistance[i - 1][j], editDistance[i][j - 1]);
                }
            }
        }
        return editDistance[word1Len][word2Len];
    }

    private static int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
