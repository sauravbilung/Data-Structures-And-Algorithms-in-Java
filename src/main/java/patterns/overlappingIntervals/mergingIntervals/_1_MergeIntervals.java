package patterns.overlappingIntervals.mergingIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1_MergeIntervals {

    public static void main(String[] args) {
        MergeIntervalsSolution solution = new MergeIntervalsSolution();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Intervals:");
        Arrays.stream(intervals).forEach(row -> System.out.printf("%s ", Arrays.toString(row)));
        System.out.println("\nMerged Intervals:");
        Arrays.stream(solution.merge(intervals)).forEach(row -> System.out.printf("%s ", Arrays.toString(row)));
    }
}

class MergeIntervalsSolution {
    public int[][] merge(int[][] intervals) {
        // a and b are two rows. Sorting is based on the first element.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];
        mergedIntervals.add(currentInterval);

        // First interval is processed twice.
        // written like this for neatness.
        for (int[] nextInterval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = nextInterval[0];
            int nextEnd = nextInterval[1];

            if (nextStart <= currentEnd) {
                currentInterval[1] = Math.max(currentInterval[1], nextEnd);
            } else {
                currentInterval = nextInterval;
                mergedIntervals.add(nextInterval);
            }
        }

        // specifying the datatype of the returned array in params.
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}

