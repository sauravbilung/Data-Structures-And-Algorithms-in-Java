package patterns.intervals.intervalInsertion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1_InsertInterval {

    public static void main(String[] args) {
        InsertIntervalSolution solution = new InsertIntervalSolution();
        int[][] intervals1 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval1 = {4, 8};
        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        int[][] intervals3 = {{1, 2}, {4, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval3 = {3, 8};
        int[][] intervals4 = {{1, 2}, {4, 7}, {8, 10}, {12, 16}};
        int[] newInterval4 = {3, 5};
        int[][] intervals5 = {{1, 2}, {5, 7}, {8, 10}, {12, 16}};
        int[] newInterval5 = {3, 5};
        int[][] intervals6 = {{1, 5}};
        int[] newInterval6 = {2, 3};
        int[][] intervals7 = {{2, 3}};
        int[] newInterval7 = {1, 5};
        System.out.println("Intervals :");
        Arrays.stream(intervals4).forEach(row -> System.out.printf("%s ", Arrays.toString(row)));
        System.out.printf("\nNew interval : %s", Arrays.toString(newInterval4));
        System.out.println("\nResult :");
        Arrays.stream(solution.insert(intervals4, newInterval4)).forEach(row -> System.out.printf("%s ", Arrays.toString(row)));
    }
}

class InsertIntervalSolution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;

        // Add all intervals before new interval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        // Add remaining intervals to result
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
