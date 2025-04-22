package patterns.strings;

import java.util.Scanner;

public class _2_Anagrams {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter word 1 : ");
        String word1 = scanner.nextLine();
        System.out.println("Enter word 2 : ");
        String word2 = scanner.nextLine();

        if (isAnagram(word1, word2)) {
            System.out.println("Both are anagrams.");
        } else {
            System.out.println("Not anagrams!");
        }
    }

    private static boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] counter = new int[26];
        int size = word1.length();

        for (int i = 0; i < size; i++) {
            counter[word1.charAt(i) - 'a']++;
            counter[word2.charAt(i) - 'a']--;
        }

        boolean isAnagram = true;

        for (int count : counter) {
            if (count != 0) {
                isAnagram = false;
                break;
            }
        }

        return isAnagram;
    }
}
