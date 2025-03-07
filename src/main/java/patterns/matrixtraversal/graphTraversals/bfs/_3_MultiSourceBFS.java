package patterns.matrixtraversal.graphTraversals.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * Note - There will be at least one 0 in the matrix.
 */
public class _3_MultiSourceBFS {

    public static void main(String... args) {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        System.out.println("Given Matrix : ");
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
        NearestDistanceToZeroSolution solution = new NearestDistanceToZeroSolution(matrix);
        solution.findNearestDistanceToZero(); // updating the same matrix
        System.out.println("Nearest distance to zero matrix : ");
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
    }
}

class NearestDistanceToZeroSolution {

    private static final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private final int[][] matrix;
    private final int rows;
    private final int cols;

    public NearestDistanceToZeroSolution(int[][] matrix) {
        this.matrix = matrix;
        rows = matrix.length;
        cols = matrix[0].length;
    }

    public void findNearestDistanceToZero() {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            int distance = matrix[x][y];

            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                boolean isNewCoordinateValid = newX >= 0 && newX < rows && newY >= 0 && newY < cols;

                if (isNewCoordinateValid) {
                    if (matrix[newX][newY] > distance + 1) {
                        matrix[newX][newY] = distance + 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
    }
}
