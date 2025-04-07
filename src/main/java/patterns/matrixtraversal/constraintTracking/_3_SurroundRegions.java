package patterns.matrixtraversal.constraintTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _3_SurroundRegions {

    public static void main(String[] args) {
        char[][] matrix = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        SurroundRegionsSolution solution = new SurroundRegionsSolution();
        solution.solve(matrix);
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
        
    }
}

class SurroundRegionsSolution {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < cols; i++) {
            // 0,i
            if (board[0][i] == 'O') {
                performDFS(board, 0, i);
            }

            // rows - 1, i
            if (board[rows - 1][i] == 'O') {
                performDFS(board, rows - 1, i);
            }
        }

        for (int i = 0; i < rows; i++) {
            // i ,0
            if (board[i][0] == 'O') {
                performDFS(board, i, 0);
            }

            // i , cols -1
            if (board[i][cols - 1] == 'O') {
                performDFS(board, i, cols - 1);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    private void performDFS(char[][] board, int startX, int startY) {
        int rows = board.length;
        int cols = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        board[startX][startY] = 'T';

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0];
            int y = p[1];

            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (isAdjacentNodeValidAndNotMarked(board, newX, newY)) {
                    board[newX][newY] = 'T';
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
    }

    private boolean isAdjacentNodeValidAndNotMarked(char[][] board, int x, int y) {
        int rows = board.length;
        int cols = board[0].length;
        return x > -1 && x < rows && y > -1 && y < cols && board[x][y] == 'O';
    }
}