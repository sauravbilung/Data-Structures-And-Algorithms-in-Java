package patterns.strings;

import java.util.*;

public class _3_GroupAnagrams {

    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};

        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            map.computeIfAbsent(new String(charArr), k -> new ArrayList<>()).add(word);
        }

        List<List<String>> groupedAnagrams = new ArrayList<>(map.values());

        for (List<String> anagrams : groupedAnagrams) {
            System.out.println(anagrams);
        }
    }
}
