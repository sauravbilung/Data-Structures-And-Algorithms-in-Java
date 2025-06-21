package algorithms.dynamicprogramming.longestSubsequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Solves the Longest Consecutive Subsequence problem.
 * Given an unsorted array of integers, it finds the length of the longest sequence
 * of consecutive elements (regardless of order) using a HashMap for O(n) time complexity.
 */

public class _2_LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        // input : 100, 4, 200, 1, 3, 2
        // output : 4. 1,2,3,4
        System.out.println("Enter space separated array contents :");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Longest consecutive subsequence : " + longestConsecutive(nums));
    }

    private static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        initializeHashMap(hmap, nums);
        int longestStreak = 0, currentStreak;
        for (int num : nums) {
            currentStreak = 0;
            // Find the starting point of the sequence and count the longest streak.
            if (hmap.containsKey(num) && hmap.get(num) == 1 && !hmap.containsKey(num - 1)) {
                while (hmap.containsKey(num++)) {
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    private static void initializeHashMap(HashMap<Integer, Integer> hmap, int[] nums) {
        for (int num : nums) {
            hmap.putIfAbsent(num, 1);
        }
    }
}
