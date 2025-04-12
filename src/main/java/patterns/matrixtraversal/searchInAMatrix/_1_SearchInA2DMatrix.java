package patterns.matrixtraversal.searchInAMatrix;

import java.util.Arrays;

/**
 * Binary Search in a 2D matrix.
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than last integer of the previous row.
 */
public class _1_SearchInA2DMatrix {

    public static void main(String[] args) {
        BinarySearchSolution solution = new BinarySearchSolution();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 17;
        System.out.print("Given matrix :\t");
        Arrays.stream(matrix).forEach(row -> System.out.printf("%s ", Arrays.toString(row)));
        System.out.printf("\nIs %d present: %b", target, solution.searchMatrix(matrix, target));
    }
}

class BinarySearchSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int low = 0, high = rows * cols - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midElement = matrix[mid / cols][mid % cols]; // Convert 1D index to 2D indices

            if (target == midElement) {
                return true;
            } else if (target < midElement) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}
