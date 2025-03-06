package patterns.matrixtraversal.graphTraversals.bfs;

import java.util.*;

public class _1_BFSTraversal {

    public static void main(String... args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        MatrixBFS solution = new MatrixBFS(matrix);
        int[] startNode = {0, 0};
        System.out.printf("BFS traversal from position %s : %s%n", Arrays.toString(startNode), solution.bfsTraversal(startNode[0], startNode[1]));

        System.out.println("Full BFS traversal of matrix: " + solution.bfsFullTraversal());
    }
}

class MatrixBFS {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private final int[][] matrix;
    private final int rows;
    private final int cols;

    public MatrixBFS(int[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
    }

    // Public method for BFS traversal from a specific position
    public List<Integer> bfsTraversal(int startX, int startY) {
        boolean[][] visited = new boolean[rows][cols];
        return bfsFromPosition(startX, startY, visited);
    }

    // Helper method to perform BFS traversal from a specific position
    private List<Integer> bfsFromPosition(int startX, int startY, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        List<Integer> traversal = new ArrayList<>();

        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            traversal.add(matrix[x][y]);

            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0], newY = y + direction[1];

                if (isValid(newX, newY, visited)) {
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return traversal;
    }

    // Full BFS traversal for entire matrix
    public List<Integer> bfsFullTraversal() {
        boolean[][] visited = new boolean[rows][cols];
        List<Integer> fullTraversal = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    fullTraversal.addAll(bfsFromPosition(i, j, visited));
                }
            }
        }
        return fullTraversal;
    }

    private boolean isValid(int x, int y, boolean[][] visited) {
        return x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y];
    }
}
