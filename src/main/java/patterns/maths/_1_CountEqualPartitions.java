package patterns.maths;

/**
 * This class provides a method to count the number of distinct partitions of a number 'n'
 * into four integers in the form (a, a, b, b) such that:
 * - 2a + 2b = n
 * - a ≠ b
 * - a > 0, b > 0
 *
 * The problem reduces to finding the number of distinct unordered pairs (a, b) such that:
 * - a + b = n / 2
 * - a ≠ b
 * - a > 0, b > 0
 *
 * Example:
 * For n = 20, we get half = 10.
 * Valid pairs (a, b) satisfying a + b = 10 and a ≠ b are:
 * (1,9), (2,8), (3,7), (4,6)
 * So, the result is 4.
 */
public class _1_CountEqualPartitions {

    public static void main(String... args) {
        int n = 20;
        System.out.println(countPartitions(n)); // Output: 7
    }

    /**
     * Counts the number of unique partitions of the form (a, a, b, b) such that:
     * - 2a + 2b = n
     * - a ≠ b
     * - a > 0, b > 0
     *
     * @param n the total sum to be partitioned
     * @return the number of valid (a, a, b, b) partitions
     */
    private static int countPartitions(int n) {
        // If n is odd, it cannot be evenly divided into 2a + 2b
        if (n % 2 != 0) {
            return 0;
        }

        int half = n / 2;

        // Total number of unique (a, b) pairs where a + b = half, a ≠ b
        // We count only a < b to avoid duplicates, so floor((half - 1) / 2)
        return (half - 1) / 2;
    }
}
