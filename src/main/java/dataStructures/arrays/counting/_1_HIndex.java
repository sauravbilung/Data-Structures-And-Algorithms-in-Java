package dataStructures.arrays.counting;

import java.util.Arrays;

/**
 * Demonstrates the computation of H-Index using a counting sort-based approach.
 * H-Index is defined as the maximum value h such that the researcher has published
 * h papers that have each been cited at least h times.
 */
public class _1_HIndex {

    public static void main(String[] args) {
        
        int[] citations = {3, 0, 6, 1, 5};               // Output: 3
        int[] citations2 = {2, 2, 2};                    // Output: 2
        int[] citations3 = {100, 100, 100, 100};         // Output: 4

        HIndexSolution solution = new HIndexSolution();

        System.out.printf("%s, HIndex : %d\n", Arrays.toString(citations), solution.hIndex(citations));
        System.out.printf("%s, HIndex : %d\n", Arrays.toString(citations2), solution.hIndex(citations2));
        System.out.printf("%s, HIndex : %d\n", Arrays.toString(citations3), solution.hIndex(citations3));
    }
}


/**
 * Computes the H-Index of a researcher given an array of citation counts for their papers.
 * This implementation uses a bucket-counting technique (similar to counting sort)
 * for optimal time complexity of O(n).
 */
class HIndexSolution {

    /**
     * Returns the H-Index for the given array of citation counts.
     *
     * @param citations An array where each element represents the number of citations of a paper.
     * @return The H-Index value.
     */
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1]; // count[i] = number of papers with exactly i citations (or more if i == n)

        // Step 1: Fill the frequency array
        // Any citation count >= n is bucketed into count[n]
        for (int c : citations) {
            if (c >= n) {
                count[n]++;
            } else {
                count[c]++;
            }
        }

        // Step 2: Iterate from highest to lowest to find maximum h
        int total = 0; // total papers with citations >= i
        for (int i = n; i >= 0; i--) {
            total += count[i];

            // Check if there are at least i papers with >= i citations
            if (total >= i) {
                return i; // This is the H-Index
            }
        }

        return 0; // Default case (should never hit for valid inputs)
    }
}

