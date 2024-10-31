package algorithms.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class _3_LongestConsecutiveSubsequence {
    public static void main(String[] args) {
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
