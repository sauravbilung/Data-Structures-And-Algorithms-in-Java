package patterns.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _3_NQueensProblem {

    private static int chessBoardSize;

    public static void main(String[] args) {
        System.out.println("Enter chess board size : ");
        Scanner scanner = new Scanner(System.in);
        chessBoardSize = scanner.nextInt();
        int currentBoardPositions[][] = new int[chessBoardSize][chessBoardSize];
        List<List<String>> result = new ArrayList<>();
        solveNQueen(result, currentBoardPositions, 0);
        System.out.println(result);
    }

    private static void solveNQueen(List<List<String>> result, int currentBoard[][], int row) {

        if (row == chessBoardSize) {
            mapBoardToResult(result, currentBoard);
        } else if (row < chessBoardSize) {
            for (int col = 0; col < chessBoardSize; col++) {
                if (isPositionSafe(currentBoard, row, col)) {
                    currentBoard[row][col] = 1;
                    solveNQueen(result, currentBoard, row + 1);
                    currentBoard[row][col] = 0;
                }
            }
        }
    }

    private static boolean isPositionSafe(int currentBoard[][], int row, int col) {
        boolean isPositionSafe = true;
        for (int i = 0; i < row; i++) { // checking attack on the same column
            if (currentBoard[i][col] == 1) {
                isPositionSafe = false;
                break;
            }
        }

        for (int i = row - 1, j = col - 1; i > -1 && j > -1; i--, j--) {
            if (currentBoard[i][j] == 1) { // checking attack on the diagonal
                isPositionSafe = false;
                break;
            }
        }

        for (int i = row - 1, j = col + 1; i > -1 && j < chessBoardSize; i--, j++) {
            if (currentBoard[i][j] == 1) { // checking attack on the diagonal
                isPositionSafe = false;
                break;
            }
        }

        return isPositionSafe;
    }

    private static void mapBoardToResult(List<List<String>> result, int[][] board) {
        List<String> currentSolution = new ArrayList<>();
        for (int i = 0; i < chessBoardSize; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < chessBoardSize; j++) {
                if (board[i][j] == 1) {
                    row.append("Q");
                } else {
                    row.append(".");
                }
            }
            currentSolution.add(row.toString());
        }
        result.add(currentSolution);
    }
}
