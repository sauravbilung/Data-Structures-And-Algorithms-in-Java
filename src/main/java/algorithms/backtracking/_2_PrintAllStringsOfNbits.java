package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _2_PrintAllStringsOfNbits {
    public static void main(String[] args) {
        System.out.println("Enter length of bit(s):");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        List<String> result = new ArrayList<>();
        generate("", result, length);
        result.forEach(System.out::println);

    }

    public static void generate(String currentString, List<String> result, int length) {
        if (currentString.length() == length) {
            result.add(currentString);
        } else {
            generate(currentString + "0", result, length);
            generate(currentString + "1", result, length);
        }
    }
}
