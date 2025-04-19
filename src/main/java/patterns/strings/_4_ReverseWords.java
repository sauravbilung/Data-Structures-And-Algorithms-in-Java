package patterns.strings;

public class _4_ReverseWords {

    public static void main(String[] args){
        String str = "  the    sky  is blue  ";
        ReverseWordsSolution solution = new ReverseWordsSolution();
        String result = solution.reverseWords(str);
        System.out.println(result);
    }
}

class ReverseWordsSolution {
    public String reverseWords(String s) {
        // Step 1: Clean up spaces
        StringBuilder str = new StringBuilder();
        int i = 0, n = s.length();

        // Skip leading spaces
        while (i < n && s.charAt(i) == ' ') i++;

        while (i < n) {
            if (s.charAt(i) != ' ') {
                str.append(s.charAt(i));
            } else if (!str.isEmpty() && str.charAt(str.length() - 1) != ' ') {
                // previous character in string builder is not ' '
                str.append(' ');
            }
            i++;
        }

        // Remove trailing space
        if (!str.isEmpty() && str.charAt(str.length() - 1) == ' ') {
            str.deleteCharAt(str.length() - 1);
        }

        // Step 2: Reverse the whole string
        reverse(str, 0, str.length() - 1);

        // Step 3: Reverse each word
        int start = 0;
        for (i = 0; i <= str.length(); i++) {
            if (i == str.length() || str.charAt(i) == ' ') {
                reverse(str, start, i - 1);
                start = i + 1;
            }
        }

        return str.toString();
    }

    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }
}

