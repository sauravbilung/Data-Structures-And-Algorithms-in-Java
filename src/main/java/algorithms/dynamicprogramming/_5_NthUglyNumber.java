package algorithms.dynamicprogramming;

import java.util.Scanner;

public class _5_NthUglyNumber {
    public static void main(String[] args) {
        System.out.print("Enter number n : ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.printf("Output : %d ", nthUglyNumber(n));
    }

    private static int nthUglyNumber(int n) {
        int i2 = 0, i3 = 0, i5 = 0, nextUglyNumber = 1;
        int nextMultipleOf2 = 2, nextMultipleOf3 = 3, nextMultipleOf5 = 5;
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        for (int i = 1; i < n; i++) {
            nextUglyNumber = minimum(nextMultipleOf2, nextMultipleOf3, nextMultipleOf5);
            uglyNumbers[i] = nextUglyNumber;
            if (nextUglyNumber == nextMultipleOf2) {
                i2++;
                nextMultipleOf2 = uglyNumbers[i2] * 2;
            }
            if (nextUglyNumber == nextMultipleOf3) {
                i3++;
                nextMultipleOf3 = uglyNumbers[i3] * 3;
            }
            if (nextUglyNumber == nextMultipleOf5) {
                i5++;
                nextMultipleOf5 = uglyNumbers[i5] * 5;
            }
        }
        return nextUglyNumber;
    }

    private static int minimum(int a, int b, int c) {
        return Math.min((Math.min(a, b)), c);
    }
}
