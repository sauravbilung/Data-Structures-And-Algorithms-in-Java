package patterns.matrixtraversal.constraintTracking;

import java.util.Arrays;

public class _4_GameOfLife {

    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        System.out.println("Given board:");
        Arrays.stream(board).forEach(row -> System.out.println(Arrays.toString(row)));

        GameOfLifeSolution solution = new GameOfLifeSolution();
        solution.gameOfLife(board);
        System.out.println("\nUpdated board:");
        Arrays.stream(board).forEach(row -> System.out.println(Arrays.toString(row)));
    }
}

class GameOfLifeSolution {

    private static final int DEAD_TO_LIVE = 2;
    private static final int LIVE_TO_DEAD = -1;

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, 1}, {1, -1},
            {1, 1}, {-1, -1}};

    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                updateBoard(board, i, j);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == DEAD_TO_LIVE) board[i][j] = 1;
                if (board[i][j] == LIVE_TO_DEAD) board[i][j] = 0;
            }
        }
    }

    private void updateBoard(int[][] board, int x, int y) {

        int rows = board.length;
        int cols = board[0].length;
        int liveCount = 0;

        for (int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            boolean isNewCoordinateValid = newX >= 0 && newX < rows && newY >= 0 && newY < cols;
            if (isNewCoordinateValid && (board[newX][newY] == 1 || board[newX][newY] == LIVE_TO_DEAD))
                liveCount++;
        }

        if (board[x][y] == 1 && (liveCount < 2 || liveCount > 3))
            board[x][y] = -1;

        if (board[x][y] == 0 && liveCount == 3)
            board[x][y] = 2;
    }
}
