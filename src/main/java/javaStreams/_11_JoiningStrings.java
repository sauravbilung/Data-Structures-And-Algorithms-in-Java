package javaStreams;

import java.util.List;
import java.util.stream.Collectors;

public class _11_JoiningStrings {

    public static void main(String[] args) {
        //basicJoin();
        //joinWithDelimiter();
        //joinWithDelimiterPrefixAndSuffix();
        //joiningAfterMapping();
        joiningCustomObjects();
    }

    private static void basicJoin() {
        List<String> words = List.of("Java", "Streams", "Rock");
        String result = words.stream().collect(Collectors.joining());
        System.out.println(result);
    }

    private static void joinWithDelimiter() {
        List<String> words = List.of("Java", "Streams", "Rock");
        String result = words.stream().collect(Collectors.joining(", "));
        System.out.println(result);
    }

    private static void joinWithDelimiterPrefixAndSuffix() {
        List<String> words = List.of("Java", "Streams", "Rock");
        String result = words.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result);
    }

    private static void joiningAfterMapping() {
        List<String> words = List.of("Java", "Streams", "Rock");
        String result = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining("-"));

        System.out.println(result);

    }

    private static void joiningCustomObjects() {
        List<Employee> employees = List.of(
                new Employee("Alice",5000),
                new Employee("Bob",6000),
                new Employee("Charlie",7000)
        );

        String names = employees.stream()
                .map(Employee::name)
                .collect(Collectors.joining(", "));

        System.out.println(names);
    }
}
