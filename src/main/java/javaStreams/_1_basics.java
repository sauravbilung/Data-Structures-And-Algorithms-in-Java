package javaStreams;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class _1_basics {

    public static void main(String[] args) {

        // print values
        //print();

        // print only even numbers.
        //printEvenNumbers();

        // convert them to uppercase.
        //convertToUpperCase();

        // Sort a list of strings in reverse alphabetical order.
        //sorting();

        // Collect all strings of length > 3 into a new list.
        //lengthGreatorThan3();

        // Count the number of strings that start with ‘R’.
        //countNumberOfStringsStartingWithR();

        // Find the first number greater than 10.
        firstNumberGreatorThan10();

        // Check if all numbers in the list are positive.
        //allPositive();

        // Find the product of all elements in the list.
        //productOfAllElements();

        // Remove duplicates and print unique elements.
        //printUniques();

        // Skip the first 2 and print the next 2 elements.
        //skipFirst2PrintNext2();
    }

    private static void print() {
        List<String> words = List.of("java", "stream", "rocks");
        System.out.printf("Inputs : %s\n", words);
        words.forEach(str -> System.out.printf("%s ", str));
    }

    private static void printEvenNumbers() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        System.out.printf("Inputs : %s\n", nums);
        nums.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.printf("%d ", n));
    }

    private static void convertToUpperCase() {
        List<String> alphabets = List.of("a", "b", "c");
        System.out.printf("Inputs : %s\n", alphabets);
        // Pass method reference or lambda
        //alphabets.stream().map(str -> str.toUpperCase()).forEach(str -> System.out.printf("%s ", str));
        alphabets.stream().map(String::toUpperCase).forEach(str -> System.out.printf("%s ", str));
    }

    private static void sorting() {
        List<String> list = List.of("apple", "banana", "grape");
        System.out.printf("Inputs : %s\n", list);
        list.stream().sorted(Collections.reverseOrder()).forEach(str -> System.out.printf("%s ", str));
    }

    private static void lengthGreatorThan3() {
        List<String> names = List.of("Ram", "Shyam", "Mohan", "Raj");
        System.out.printf("Inputs : %s\n", names);
        // If we want a normal, editable list → use .collect(Collectors.toList()) (available from java 8+)
        // If we just need a read-only list (no modification needed) → use .toList() (available from java 16+)
        List<String> namesLenGreatorThan3 = names.stream().filter(str -> str.length() > 3).collect(Collectors.toList());
        namesLenGreatorThan3.stream().forEach(str -> System.out.printf("%s ", str));
    }

    private static void countNumberOfStringsStartingWithR() {
        List<String> names = List.of("Ram", "Ravi", "Mohan", "Raj");
        System.out.printf("Inputs : %s\n", names);
        int count = (int) names.stream().filter(str -> str.charAt(0) == 'R' || str.charAt(0) == 'r').count();
        System.out.printf("Number of string starting with R : %d", count);
    }

    private static void firstNumberGreatorThan10() {
        List<Integer> nums = List.of(3, 8, 12, 4, 18);
        System.out.printf("Inputs : %s\n", nums);
        Optional<Integer> result = nums.stream().filter(num -> num > 10).findFirst();
        result.ifPresent(integer -> System.out.println("First number greator than 10 :" + integer));
    }

    private static void allPositive() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        System.out.printf("Inputs : %s\n", nums);
        // .allMatch() checks if all elements in the stream satisfy a given condition.
        boolean result = nums.stream().allMatch(num -> num > 0);
        System.out.println("Are all numbers positive : " + result);
    }

    private static void productOfAllElements() {
        List<Integer> nums = List.of(1, 2, 3, 4);
        System.out.printf("Inputs : %s\n", nums);
        int multiplicationResult = nums.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Multiplication result : " + multiplicationResult);
    }

    private static void printUniques() {
        List<Integer> nums = List.of(1, 2, 2, 3, 1, 4);
        System.out.printf("Inputs : %s\n", nums);
        nums.stream().distinct().forEach(num -> System.out.printf("%d ", num));
    }

    private static void skipFirst2PrintNext2() {
        List<Integer> nums = List.of(10, 20, 30, 40, 50);
        System.out.printf("Inputs : %s\n", nums);
        nums.stream().skip(2).limit(2).forEach(num -> System.out.print(" " + num));
    }
}
