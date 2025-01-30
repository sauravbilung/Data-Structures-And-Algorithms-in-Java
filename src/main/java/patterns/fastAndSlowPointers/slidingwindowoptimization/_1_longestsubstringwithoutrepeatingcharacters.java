package patterns.fastAndSlowPointers.slidingwindowoptimization;

import java.util.HashSet;

public class _1_longestsubstringwithoutrepeatingcharacters {
    public static void main(String[] args) {
        String[] texts = {"abcabcbb", "bbbbb", "pwwkew", "bbbabb", "ckilbkd"};

        for (String text : texts) {
            System.out.printf("longest substring lenght for %s : %d \n", text, findLengthOfLongestSubstring(text));
        }
    }

    private static int findLengthOfLongestSubstring(String str) {
        HashSet<Character> set = new HashSet<>();

        int maxWindowSize = 0;
        int windowStart = 0, windowEnd = 0;

        while (windowEnd < str.length()) {

            while (set.contains(str.charAt(windowEnd))) {
                set.remove(str.charAt(windowStart++));
            }

            maxWindowSize = Math.max(maxWindowSize, windowEnd - windowStart + 1);
            set.add(str.charAt(windowEnd++));
        }

        return maxWindowSize;
    }
}
