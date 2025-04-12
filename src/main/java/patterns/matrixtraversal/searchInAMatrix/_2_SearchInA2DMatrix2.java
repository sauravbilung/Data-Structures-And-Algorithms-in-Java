package patterns.matrixtraversal.searchInAMatrix;

import java.util.Arrays;

/**
 * Staircase search in 2d matrix
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 */
public class _2_SearchInA2DMatrix2 {

    public static void main(String... args) {
        StaircaseSearchSolution solution = new StaircaseSearchSolution();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 20;

        System.out.println("Given Matrix:");
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));

        boolean result = solution.searchMatrix(matrix, target);
        System.out.printf("Is %d present? %b%n", target, result);
    }
}

class StaircaseSearchSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = 0, j = cols - 1;
        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
