package patterns.fastAndSlowPointers.slidingwindowoptimization;

import java.util.HashMap;

public class _3_longestSubstringWithatMostKdistinctCharacters {

    public static void main(String[] args) {
        String text = "aabacbebebe";
        int k = 2;
        System.out.printf("Longest substring with at most %d distinct characters: %d", k, longestSubstringWithAtMostKDistinctCharacters(text, k));
    }

    private static int longestSubstringWithAtMostKDistinctCharacters(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxWindowSize = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            map.merge(s.charAt(windowEnd), 1, Integer::sum);

            while (map.size() > k) {
                map.computeIfPresent(s.charAt(windowStart), (key, val) -> (val > 1) ? val - 1 : null);
                windowStart++;
            }

            maxWindowSize = Math.max(maxWindowSize, windowEnd - windowStart + 1);

        }

        return maxWindowSize;
    }
}

