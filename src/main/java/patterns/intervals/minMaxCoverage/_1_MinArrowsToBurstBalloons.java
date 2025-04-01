package patterns.intervals.minMaxCoverage;

import java.util.Arrays;

/**
 * **Leetcode 452: Minimum Number of Arrows to Burst Balloons**
 *
 * <p>Given a set of balloons represented as 2D intervals `[start, end]`,
 * an arrow shot at position `x` can burst all balloons where `start ≤ x ≤ end`.</p>
 *
 * <p>The task is to determine the **minimum number of arrows** required
 * to burst all balloons.</p>
 */

public class _1_MinArrowsToBurstBalloons {

    public static void main(String[] args) {
        MinArrowsToBurstBallonsSolution solution = new MinArrowsToBurstBallonsSolution();
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println("Points :");
        Arrays.stream(points).forEach(row -> System.out.printf("%s ", Arrays.toString(row)));
        System.out.printf("\nArrows required :%d", solution.findMinArrowShots(points));
    }
}

class MinArrowsToBurstBallonsSolution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrows = 1;
        int position = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > position) {
                arrows++;
                position = points[i][1];
            }
        }
        return arrows;
    }
}
