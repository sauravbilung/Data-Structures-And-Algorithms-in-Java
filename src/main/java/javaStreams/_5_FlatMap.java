package javaStreams;

import java.util.Arrays;
import java.util.List;

public class _5_FlatMap {

    public static void main(String[] args) {
        // flatMap is used to flatten nested structures (like List<List<T>>) into a single stream of elements.
        // It takes a Function<T, Stream<R>>, meaning for each element T, it returns a Stream<R>. flatMap in Java takes a function that returns a Stream.
        // flatMap then merges all these individual streams into a single continuous stream.

        //flattenListOfList();
        //flattenListOfArray();
        //wordsFromSentences();
        flattenListOfIntegers();
    }

    private static void flattenListOfList() {
        List<List<String>> nestedList = List.of(
                List.of("a", "b"),
                List.of("c", "d"),
                List.of("e", "f")
        );

        // nestedList.stream() creates a Stream<List<String>>, where each element is a List<String>.
        // Inside flatMap, list.stream() converts each List<String> into a Stream<String>.
        // flatMap merges (flattens) all these individual Stream<String> into a single Stream<String>.
        // forEach then prints each string element one by one.
        // List::stream also works
        nestedList.stream().flatMap(list -> list.stream()).forEach(System.out::println);
    }

    private static void flattenListOfArray() {
        List<String[]> listOfArrays = List.of(
                new String[]{"a", "b"},
                new String[]{"c", "d"},
                new String[]{"e", "f"}
        );

        // Arrays::stream also works
        listOfArrays.stream().flatMap(array -> Arrays.stream(array)).forEach(System.out::println);
    }

    private static void wordsFromSentences() {
        List<String> sentences = List.of(
                "Java is awesome",
                "Streams are powerful",
                "FlatMap flattens structures"
        );

        sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" "))).forEach(System.out::println);
    }

    private static void flattenListOfIntegers() {
        List<List<Integer>> listOfNumbers = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8)
        );

        // Collections::stream / List::Stream also works
        listOfNumbers.stream().flatMap(list -> list.stream()).forEach(System.out::println);
    }
}
