package patterns.intervals.eraseOverlappingIntervals;

import java.util.Arrays;

public class _1_NonOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = {
                {-52, 31}, {-73, -26}, {82, 97}, {-65, -11}, {-62, -49},
                {95, 99}, {58, 95}, {-31, 49}, {66, 98}, {-63, 2},
                {30, 47}, {-40, -26}
        };

        NonOverlappingIntervalsSolution solution = new NonOverlappingIntervalsSolution();
        int result = solution.eraseOverlapIntervals(intervals);
        System.out.printf("Number of intervals to remove to make them non-overlapping: %d%n", result);
    }
}

class NonOverlappingIntervalsSolution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Sort by end time to apply greedy approach
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removed = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                removed++; // Overlapping, remove it
            } else {
                prevEnd = intervals[i][1]; // No overlap, update end
            }
        }

        return removed;
    }
}
