package patterns.matrixtraversal.graphTraversals.dfs;

import java.util.*;

public class _1_DFSTraversal {

    public static void main(String... args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[] startNode = {0, 0};
        MatrixDFS solution = new MatrixDFS(matrix);

        System.out.printf("DFS traversal from node %s: %s%n",
                Arrays.toString(startNode), solution.dfsFromNode(startNode[0], startNode[1]));

        System.out.printf("\nDFS complete traversal: %s", solution.dfsCompleteTraversal());
    }
}

class MatrixDFS {
    private final int[][] matrix;
    private final int rows, cols;
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right

    public MatrixDFS(int[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
    }

    // DFS traversal from a given starting node
    public List<Integer> dfsFromNode(int startX, int startY) {
        boolean[][] visited = new boolean[rows][cols];
        return performDFS(startX, startY, visited);
    }

    // DFS traversal covering all unvisited nodes in the matrix
    public List<Integer> dfsCompleteTraversal() {
        List<Integer> fullResult = new ArrayList<>();
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    fullResult.addAll(performDFS(i, j, visited));
                }
            }
        }
        return fullResult;
    }

    private List<Integer> performDFS(int startX, int startY, boolean[][] visited) {
        List<Integer> result = new ArrayList<>();
        Deque<int[]> stack = new ArrayDeque<>();

        stack.push(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int x = cell[0], y = cell[1];
            result.add(matrix[x][y]);

            // Process neighbors in a standard order (Up, Down, Left, Right)
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (isValid(newX, newY, visited)) {
                    stack.push(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return result;
    }

    private boolean isValid(int x, int y, boolean[][] visited) {
        return x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y];
    }
}
