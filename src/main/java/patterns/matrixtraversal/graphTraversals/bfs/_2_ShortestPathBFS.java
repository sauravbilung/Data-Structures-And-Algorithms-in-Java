package patterns.matrixtraversal.graphTraversals.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

/**
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
 * If there is no clear path, return -1.
 *
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 */
public class _2_ShortestPathBFS {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };

        System.out.println("Given Grid:");
        Arrays.stream(grid).forEach(row -> System.out.println(Arrays.toString(row)));

        ShortestPathSolution solution = new ShortestPathSolution();
        int shortestPath = solution.shortestPathBinaryMatrix(grid);

        System.out.println("Shortest Path in Binary Matrix: " + shortestPath);
    }
}

class ShortestPathSolution {

    private static final int[][] directions = {
            {1, 0}, {0, 1}, {1, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, -1}, {-1, 1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1)
            return -1;

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            int dist = cell[2];

            if (x == rows - 1 && y == cols - 1) {
                return dist;
            }

            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (isValid(newX, newY, rows, cols, grid, visited)) {
                    queue.offer(new int[]{newX, newY, dist + 1});
                    visited[newX][newY] = true;
                }
            }
        }

        return -1;
    }

    private boolean isValid(int x, int y, int rows, int cols, int[][] grid, boolean[][] visited) {
        return x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y] && grid[x][y] == 0;
    }
}
