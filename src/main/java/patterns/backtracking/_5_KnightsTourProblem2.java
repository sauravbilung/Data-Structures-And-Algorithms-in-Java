package patterns.backtracking;

import java.util.Arrays;

/**
 * When moveNumber starts at 0
 */
public class _5_KnightsTourProblem2 {

    private static final int SIZE = 8;

    public static void main(String[] args) {
        int[][] solution = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(solution[i], -1);
        }

        //int[] xMoves = {1, -1, -1, 1, 2, 2, -2, -2};
        //int[] yMoves = {2, -2, 2, -2, 1, -1, 1, -1};

        int[] xMoves = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};

        solution[0][0] = 0;
        if (solveKnightTour(0, 0, 0, xMoves, yMoves, solution)) {
            System.out.println("Solution exist");
            Arrays.stream(solution).map(Arrays::toString).forEach(System.out::println);
        } else {
            System.out.println("No solution exist !");
        }
    }

    private static boolean solveKnightTour(int x, int y, int moveNumber, int[] xMoves, int[] yMoves, int[][] solution) {
        int nextX, nextY, nextMoveNumber;
        boolean doesSolutionExist = false;

        if (moveNumber == SIZE * SIZE - 1) {
            doesSolutionExist = true;
        }
        else {
            for (int i = 0; i < xMoves.length; i++) {
                nextX = x + xMoves[i];
                nextY = y + yMoves[i];
                if (isCoordinateSafe(nextX, nextY, solution)) {
                    nextMoveNumber = moveNumber + 1;
                    solution[nextX][nextY] = nextMoveNumber;
                    doesSolutionExist = solveKnightTour(nextX, nextY, nextMoveNumber, xMoves, yMoves, solution);

                    if (doesSolutionExist) {
                        break;
                    }
                    solution[nextX][nextY] = -1;
                }
            }
        }

        return doesSolutionExist;
    }


    private static boolean isCoordinateSafe(int x, int y, int[][] solution) {
        return x > -1 && x < SIZE && y > -1 && y < SIZE && solution[x][y] == -1;
    }
}
