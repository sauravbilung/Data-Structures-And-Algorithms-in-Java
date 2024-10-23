package algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Unoptimised version
 * */
public class _4_RatInAMazeUnoptimised {

    private static final int mazeSize = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter starting points separated by space :");
        int[] source = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Enter destination points separated by space :");
        int[] target = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Enter the number of blocked pairs : ");
        int blockedPairs = scanner.nextInt();
        scanner.nextLine(); // to read the leftover \n character
        int[][] blocked = new int[blockedPairs][1];
        for (int i = 0; i < blockedPairs; i++) {
            String inputMsg = String.format("Enter blocked pair %d of %d separated by space :", i+1, blockedPairs);
            System.out.println(inputMsg);
            blocked[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        /*
        // Testing the inputs received
        System.out.println("Maze size : "+ mazeSize);
        System.out.println("Start : " + Arrays.toString(start));
        System.out.println("Target : " + Arrays.toString(target));
        System.out.println("Blocked array :" + Arrays.deepToString(blocked));
         */
        System.out.println("IsEscapePossible : " + isEscapePossible(blocked, source, target));
    }

    private static boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {

        boolean isEscapeFound = Arrays.equals(source, target);

        if (!isEscapeFound && source[0] > -1 && source[1] < mazeSize) {
            List<String> fetchedEscapeRoutes = fetchEscapeRoutes(source, blocked);
            if (!fetchedEscapeRoutes.isEmpty()) {
                if (fetchedEscapeRoutes.contains("N")) {
                    int[][] newBlocked = newBlockedPoints(blocked, source);
                    int[] newSource = new int[]{source[0] - 1, source[1]};
                    isEscapeFound = isEscapePossible(newBlocked, newSource , target);
                }
                if (fetchedEscapeRoutes.contains("S") && !isEscapeFound) {
                    int[][] newBlocked = newBlockedPoints(blocked, source);
                    int[] newSource = new int[]{source[0] + 1, source[1]};
                    isEscapeFound = isEscapePossible(newBlocked, newSource , target);
                }
                if (fetchedEscapeRoutes.contains("E") && !isEscapeFound) {
                    int[][] newBlocked = newBlockedPoints(blocked, source);
                    int[] newSource = new int[]{source[0], source[1] + 1};
                    isEscapeFound = isEscapePossible(newBlocked, newSource, target);
                }
                if (fetchedEscapeRoutes.contains("W") && !isEscapeFound) {
                    int[][] newBlocked = newBlockedPoints(blocked, source);
                    int[] newSource = new int[]{source[0], source[1] - 1};
                    isEscapeFound = isEscapePossible(newBlocked, newSource, target);
                }
            }
        }
        return isEscapeFound;
    }

    private static List<String> fetchEscapeRoutes(int[] source, int[][] blockedRoutes) {
        int[] north = {source[0] - 1, source[1]};
        int[] south = {source[0] + 1, source[1]};
        int[] east = {source[0], source[1] + 1};
        int[] west = {source[0], source[1] - 1};
        boolean isNorthBlocked = false;
        boolean isSouthBlocked = false;
        boolean isEastBlocked = false;
        boolean isWestBlocked = false;
        List<String> allEscapeRoutes = new ArrayList<>();
        for (int[] blockedRoute : blockedRoutes) {
            isNorthBlocked = (Arrays.equals(blockedRoute, north) || isNorthBlocked);
            isSouthBlocked = Arrays.equals(blockedRoute, south) || isSouthBlocked;
            isEastBlocked = Arrays.equals(blockedRoute, east) || isEastBlocked;
            isWestBlocked = Arrays.equals(blockedRoute, west) || isWestBlocked;
        }

        if (!isNorthBlocked && north[0] > -1) {
            allEscapeRoutes.add("N");
        }
        if (!isSouthBlocked && south[0] < mazeSize) {
            allEscapeRoutes.add("S");
        }
        if (!isEastBlocked && east[1] < mazeSize) {
            allEscapeRoutes.add("E");
        }
        if (!isWestBlocked && west[1] > -1) {
            allEscapeRoutes.add("W");
        }
        return allEscapeRoutes;
    }

    private static int[][] newBlockedPoints(int[][] blocked, int[] source) {
        int[][] newBlocked = new int[blocked.length + 1][1];
        int i;
        for (i = 0; i < blocked.length; i++) {
            newBlocked[i] = blocked[i];
        }
        newBlocked[i] = source;
        return newBlocked;
    }
}

