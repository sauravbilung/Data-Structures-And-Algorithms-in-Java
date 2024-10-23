package algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _4_RatInAMaze {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of maze : ");
        int mazeSize = scanner.nextInt();
        scanner.nextLine(); // to read the leftover \n character
        int[][] maze = new int[mazeSize][1];
        for (int i = 0; i < mazeSize; i++) {
            String inputMsg = String.format("Enter contents of row %d of %d separated by space :", i + 1, mazeSize);
            System.out.println(inputMsg);
            maze[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        /*
        // Testing the inputs received
        System.out.println("maze :" + Arrays.deepToString(maze));
         */

        ArrayList<String> escapePaths = findPath(maze);
        System.out.println("Printing final results");
        if (!escapePaths.isEmpty()) {
            escapePaths.forEach(System.out::println);
        } else {
            System.out.println("-1");
        }
    }

    private static ArrayList<String> findPath(int[][] mat) {
        int[] source = {0, 0};
        int[] target = {mat.length - 1, mat.length - 1};
        ArrayList<String> result = new ArrayList<>();
        findAllEscapePaths(mat, source, target, "", result);
        return result;
    }

    private static void findAllEscapePaths(int[][] maze, int[] source, int[] target, String currentPath, List<String> result) {

        boolean isEscapeFound = Arrays.equals(source, target);

        if (isEscapeFound) {
            System.out.println("Escape path found : " + currentPath);
            result.add(currentPath);
        }

        boolean isSourcePointWithinMazeBoundary = source[0] > -1 && source[0] < maze.length && source[1] > -1 && source[1] < maze.length;

        if (!isEscapeFound && isSourcePointWithinMazeBoundary && maze[source[0]][source[1]] != 0) {
            List<String> fetchedEscapeDirections = fetchEscapeDirections(maze, source);
            if (!fetchedEscapeDirections.isEmpty()) {
                if (fetchedEscapeDirections.contains("U")) {
                    int[] newSource = new int[]{source[0] - 1, source[1]};
                    int[][] updatedMaze = copyMaze(maze);
                    updatedMaze[source[0]][source[1]] = 0;
                    findAllEscapePaths(updatedMaze, newSource, target, currentPath + "U", result);
                }
                if (fetchedEscapeDirections.contains("D")) {
                    int[] newSource = new int[]{source[0] + 1, source[1]};
                    int[][] updatedMaze = copyMaze(maze);
                    updatedMaze[source[0]][source[1]] = 0;
                    findAllEscapePaths(updatedMaze, newSource, target, currentPath + "D", result);
                }
                if (fetchedEscapeDirections.contains("R")) {
                    int[] newSource = new int[]{source[0], source[1] + 1};
                    int[][] updatedMaze = copyMaze(maze);
                    updatedMaze[source[0]][source[1]] = 0;
                    findAllEscapePaths(updatedMaze, newSource, target, currentPath + "R", result);
                }
                if (fetchedEscapeDirections.contains("L")) {
                    int[] newSource = new int[]{source[0], source[1] - 1};
                    int[][] updatedMaze = copyMaze(maze);
                    updatedMaze[source[0]][source[1]] = 0;
                    findAllEscapePaths(updatedMaze, newSource, target, currentPath + "L", result);
                }
            }
        }
    }

    private static List<String> fetchEscapeDirections(int[][] maze, int[] source) {
        int[] up = {source[0] - 1, source[1]};
        int[] down = {source[0] + 1, source[1]};
        int[] right = {source[0], source[1] + 1};
        int[] left = {source[0], source[1] - 1};
        List<String> allEscapeRoutes = new ArrayList<>();

        if (up[0] > -1 && maze[up[0]][up[1]] == 1) {
            allEscapeRoutes.add("U");
        }
        if (down[0] < maze.length && maze[down[0]][down[1]] == 1) {
            allEscapeRoutes.add("D");
        }
        if (right[1] < maze.length && maze[right[0]][right[1]] == 1) {
            allEscapeRoutes.add("R");
        }
        if (left[1] > -1 && maze[left[0]][left[1]] == 1) {
            allEscapeRoutes.add("L");
        }
        return allEscapeRoutes;
    }

    private static int[][] copyMaze(int[][] maze) {
        int[][] copiedMaze = new int[maze.length][maze.length];
        for (int i = 0; i < maze.length; i++) {
            copiedMaze[i] = maze[i].clone();
        }
        return copiedMaze;
    }
}

