package algorithms.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class _6_CheckKnightTourConfiguration {
    public static void main(String[] args) {
        System.out.println("Enter matrix size : ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[size][size];
        System.out.println("Enter each contents separated by space : ");
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter contents for row %d of %d%n", i + 1, size);
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println("Is Knight tour valid : " + checkValidGrid(matrix));
    }

    private static boolean checkValidGrid(int[][] grid) {

        int[] xMoves = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};
        int nextX = 0, nextY = 0, moveNumber = 0;
        boolean nextPositionFound = grid[0][0] == 0;

        while (moveNumber < grid.length * grid.length && nextPositionFound) {
            nextPositionFound = false;
            for (int i = 0; i < xMoves.length; i++) {
                nextX = nextX + xMoves[i];
                nextY = nextY + yMoves[i];
                if (isNextCoordinateValid(nextX, nextY, grid, moveNumber + 1)) {
                    nextPositionFound = true;
                    break;
                } else {
                    nextX = nextX - xMoves[i];
                    nextY = nextY - yMoves[i];
                }
            }
            moveNumber++;
        }

        return moveNumber == grid.length * grid.length;
    }

    private static boolean isNextCoordinateValid(int x, int y, int[][] grid, int moveNumber) {
        return x > -1 && x < grid.length && y > -1 && y < grid.length && grid[x][y] == moveNumber;
    }

}
