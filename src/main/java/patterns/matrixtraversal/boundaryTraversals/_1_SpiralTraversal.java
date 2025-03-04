package patterns.matrixtraversal.boundaryTraversals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1_SpiralTraversal {

    public static void main(String... args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println("Given matrix : ");
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
        SpiralTraversalSolution solution = new SpiralTraversalSolution();
        List<Integer> spiralOrderTraversal = solution.spiralOrder(matrix);
        System.out.printf("\nSpiral order : %s", spiralOrderTraversal);

    }
}

class SpiralTraversalSolution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralOrderTraversal = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                spiralOrderTraversal.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                spiralOrderTraversal.add(matrix[i][right]);
            }
            right--;
            // Check if there is a row remaining before traversing right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    spiralOrderTraversal.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // Check if there is a column remaining before traversing bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    spiralOrderTraversal.add(matrix[i][left]);
                }
                left++;
            }
        }
        return spiralOrderTraversal;
    }
}
