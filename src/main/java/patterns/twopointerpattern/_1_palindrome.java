package patterns.twopointerpattern;

// Two pointers meeting in the middle
public class _1_palindrome {
    public static void main(String[] args) {
        String text1 = "abbaabba";
        String text2 = "abbaabbad";
        System.out.printf("Is string %s palindrome ? : %b",text1, isPalindrome(text1));
        System.out.printf("\nIs string %s palindrome ? : %b",text2, isPalindrome(text2));
    }

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
