package javaStreams;

import java.util.List;
import java.util.Optional;

public class _8_AdvanceReduce {

    public static void main(String[] args) {
        /*
        * 📚 What is reduce() in Java Streams ?
        *
        * ✅ reduce() is a terminal operation that combines elements of a stream into a single result.
          Think of it like: Taking two elements -> Reducing them into one -> Then combining the result with the next element
          And so on...
        * */

        //sumIntegers();
        //productIntegers();
        //findMinMax();
        //stringConcatenation();
        sumEmployeeSalaries();
    }

    private static void sumIntegers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // or reduce(0, (a,b) -> a + b)
        int result = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum : " + result);
    }

    private static void productIntegers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        int result = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product : " + result);
    }

    private static void findMinMax() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        Optional<Integer> min = numbers.stream().reduce((a, b) -> a < b ? a : b);
        Optional<Integer> max = numbers.stream().reduce((a, b) -> a > b ? a : b);
        min.ifPresent(num -> System.out.println("Minimum : " + num));
        max.ifPresent(num -> System.out.println("Maximum : " + num));
    }

    private static void stringConcatenation() {
        List<String> words = List.of("Java", "is", "awesome");

        String sentence = words.stream().reduce("", (a, b) -> a + " " + b);
        // or String sentence = words.stream().collect(Collectors.joining(" "));
        System.out.println(sentence);
    }

    private static void sumEmployeeSalaries() {
        List<Employee> employees = List.of(
                new Employee("Alice", 5000),
                new Employee("Bob", 7000),
                new Employee("Charlie", 6000)
        );

        int sum = employees.stream().map(Employee::salary).reduce(0, Integer::sum);
        System.out.println("Sum salaries : " + sum);
    }
}

/*
* When to use identity vs not
*
*     Form                              | Identity?                   | Output if list is empty?
      reduce(identity, accumulator)     | Yes                         | Returns identity (default safe value)
      reduce(accumulator)               | No                          | Returns Optional.empty()
* */