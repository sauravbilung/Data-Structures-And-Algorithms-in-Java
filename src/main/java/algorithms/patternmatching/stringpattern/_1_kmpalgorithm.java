package algorithms.patternmatching.stringpattern;

public class _1_kmpalgorithm {

    public static void main(String[] args) {
        String text = "BABABABABCABABCABAB";
        String pattern = "ABABCABAB";
        System.out.printf("text : %s", text);
        System.out.printf("\npattern : %s", pattern);
        kmpSearch(text, pattern);
    }

    private static void kmpSearch(String text, String pattern) {
        int i = 0, j = 0;
        int[] lps = buildLPS(pattern);
        /*
         We use the LPS array to determine the next position in the pattern
         This allows the algorithm to reuse the part of the pattern that has already been matched
         and skip unnecessary comparisons.
         */
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                System.out.printf("\nFound at : %d", i - j);
                /*
                 LPS ensures we find overlapping matches. For example, after finding a match at (5, 13),
                 LPS lets us continue to find the next match at (10, 18) without restarting the search.
                */
                j = lps[j - 1];
            } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    private static int[] buildLPS(String pattern) {
        int i = 1, length = 0;
        int[] lps = new int[pattern.length()];
        lps[0] = 0;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                lps[i++] = ++length;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
        return lps;
    }
}
