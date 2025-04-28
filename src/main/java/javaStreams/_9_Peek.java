package javaStreams;

import java.util.List;

public class _9_Peek {

    public static void main(String[] args) {
        /*
        * 📚 What is peek() in Java Streams?
        *
        * ✅ peek() is an intermediate operation that:
          Lets us look at each element as it passes through the stream pipeline.
          Used mostly for debugging and logging without modifying the elements.
        * */

        // Warning: peek() does nothing without a terminal operation
        // No terminal operation - peek will not run
        // names.stream().peek(System.out::println);

        //basicPeeking();
        chainingPeek();
    }

    private static void basicPeeking() {

        List<String> names = List.of("alice", "bob", "charlie");
        names.stream()
                .peek(name -> System.out.println("Before map: " + name))
                .map(String::toUpperCase)
                .peek(upper -> System.out.println("After map: " + upper))
                .forEach(System.out::println);
    }

    private static void chainingPeek() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        nums.stream()
                .peek(n -> System.out.println("Original: " + n))
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.println("After filter: " + n))
                .map(n -> n * n)
                .peek(n -> System.out.println("After map (square): " + n))
                .forEach(n -> System.out.println("Final output: " + n));

    }
}
