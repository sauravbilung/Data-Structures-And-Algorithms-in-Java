package patterns.backtracking;

import java.util.Arrays;

/**
 * When move number starts at 1
 * */
public class _5_KnightsTourProblem {

    private static final int SIZE = 8;

    public static void main(String[] args) {
        int[][] solution = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(solution[i], -1);
        }

        int[] xMoves = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};

        // To validate below moves
        //int[] xMoves = {1, -1, -1, 1, 2, 2, -2, -2};
        //int[] yMoves = {2, -2, 2, -2, 1, -1, 1, -1};

        solution[0][0] = 0;
        if (solveKnightTour(0, 0, 1, xMoves, yMoves, solution)) {
            Arrays.stream(solution).map(Arrays::toString).forEach(System.out::println);
        } else {
            System.out.println("No solution exist !");
        }
    }

    private static boolean solveKnightTour(int x, int y, int moveNumber, int[] xMoves, int[] yMoves, int[][] solution) {
        int nextX, nextY;
        boolean doesSolutionExist = false;

        if (moveNumber == SIZE * SIZE) {
            doesSolutionExist = true;
        } else {
            for (int i = 0; i < xMoves.length; i++) {
                nextX = x + xMoves[i];
                nextY = y + yMoves[i];
                if (isCoordinateSafe(nextX, nextY, solution)) {
                    solution[nextX][nextY] = moveNumber;

                    doesSolutionExist = solveKnightTour(nextX, nextY, moveNumber + 1, xMoves, yMoves, solution);
                    if (doesSolutionExist) {
                        break;
                    } else {
                        solution[nextX][nextY] = -1;
                    }
                }
            }
        }

        return doesSolutionExist;
    }


    private static boolean isCoordinateSafe(int x, int y, int[][] solution) {
        return (x > -1 && x < SIZE && y > -1 && y < SIZE && solution[x][y] == -1);
    }
}
