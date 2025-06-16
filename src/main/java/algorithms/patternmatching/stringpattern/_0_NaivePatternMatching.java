package algorithms.patternmatching.stringpattern;

public class _0_NaivePatternMatching {

    public static void main(String[] args) {
        String text = "ababcabcabababdababd";
        String pattern = "ababd";
        solution(text, pattern);
    }

    public static void solution(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (pattern.charAt(j) != text.charAt(i + j)) break;
            }

            if (j == m) {
                System.out.printf("\nMatch found at position : %d", i);
            }
        }
    }
}
