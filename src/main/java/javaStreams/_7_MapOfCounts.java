package javaStreams;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _7_MapOfCounts {

    public static void main(String[] args) {
        /*
        Map of Counts is one of the most practical and frequent debugging and analysis tricks using Java Streams — especially when you want
        to find duplicates, frequency, or analyze data quickly.

        📚 What is "Map of Counts" in Java Streams?
        ✅ It means building a Map<Key, Count> where:
        Key = element
        Value = number of times it appears

        🔥 How to Create Map of Counts?
        We use : .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        Function.identity() ➔ says "group by the value itself".
        Collectors.counting() ➔ says "count how many per group".
        */

        //countStrings();
        //countOfIntegers();
        //charCount();
        findDuplicates();
    }

    private static void countStrings() {
        List<String> fruits = List.of("apple", "banana", "apple", "grape", "apple", "grape");
        // Function.identity() : says group by the element itself.
        // Collectors.counting() : count occurrences in the group.
        Map<String, Long> fruitCount = fruits.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        fruitCount.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    private static void countOfIntegers() {
        List<Integer> numbers = List.of(1, 2, 2, 3, 3, 3, 4);
        Map<Integer, Long> numberCount = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        numberCount.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    private static void charCount() {
        String word = "programming";
        Map<Character, Long> charCount = word.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        charCount.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    private static void findDuplicates() {
        List<String> words = List.of("one", "two", "one", "three", "two", "four");

        Map<String, Long> count = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<String> duplicates = count.entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(duplicates);
    }

}
