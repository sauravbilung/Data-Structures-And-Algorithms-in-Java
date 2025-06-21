package algorithms.dynamicprogramming.matrix;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Finds the size of the largest square sub-matrix consisting only of 1s in a binary matrix
 * using dynamic programming. Returns the side length of the largest such square.
 */

public class _1_MaximumSizeSquareSubMatrixWithAll1s {
    public static void main(String[] args) {

        // input : int[][] matrix = {
        //    {0, 1, 1, 0, 1},
        //    {1, 1, 1, 1, 0},
        //    {1, 1, 1, 1, 0},
        //    {1, 1, 1, 1, 1},
        //    {0, 0, 1, 1, 1}
        //};

        // output : 3
        // 1 1 1
        // 1 1 1
        // 1 1 1
        System.out.println("Enter space separated dimensions of the matrix :");
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(" ");
        int m = Integer.parseInt(dimensions[0]);
        int n = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.out.printf("Enter contents of row %d/%d : ", i + 1, m);
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.printf("Output : %d", maximalSquare(matrix));
    }

    private static int maximalSquare(int[][] matrix) {
        int maxSubMatrix = 0, minSideLength;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != 0 && j != 0 && matrix[i][j] == 1) {
                    minSideLength = Math.min((Math.min(matrix[i - 1][j], matrix[i][j - 1])), matrix[i - 1][j - 1]);
                    matrix[i][j] = minSideLength + 1;
                }

                if (matrix[i][j] != 0) {
                    maxSubMatrix = Math.max(matrix[i][j], maxSubMatrix);
                }
            }
        }
        return maxSubMatrix;
    }
}
