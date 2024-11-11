package algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _8_PrintAllNbitIntegersWithNoConsecutiveZeros {
    public static void main(String[] args) {
        System.out.println("Enter a number : ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Output : " + validStrings(n));
    }

    private static List<String> validStrings(int n) {
        List<String> validStrings = new ArrayList<>();
        generateValidStrings(validStrings, "", n);
        return validStrings;
    }

    private static void generateValidStrings(List<String> validStrings, String str, int n) {
        if (str.length() == n) {
            validStrings.add(str);
        } else {
            if (!str.isEmpty() && str.charAt(str.length() - 1) == '0') {
                generateValidStrings(validStrings, str + "1", n);
            } else {
                generateValidStrings(validStrings, str + "0", n);
                generateValidStrings(validStrings, str + "1", n);
            }
        }
    }
}
