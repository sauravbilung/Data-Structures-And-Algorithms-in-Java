package patterns.matrixtraversal.constraintTracking;

import java.util.Arrays;

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 */
public class _2_SetZeros {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        SetZerosSolution solution = new SetZerosSolution();
        solution.setZeroes(matrix);

        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
    }
}

class SetZerosSolution {
    public void setZeroes(int[][] matrix) {

        int r = matrix.length;
        int c = matrix[0].length;

        boolean[] rows = new boolean[r];
        boolean[] cols = new boolean[c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}