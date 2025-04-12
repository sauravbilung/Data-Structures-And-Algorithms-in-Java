package patterns.bitmanipulation;

import java.math.BigInteger;

public class _2_AddBinary2 {
    public static void main(String... args) {
        // BigInteger x = new BigInteger("3"); // will accept 3;
        BigInteger x = new BigInteger("11", 2); // Binary "11" (decimal 3)
        BigInteger y = new BigInteger("1", 2);  // Binary "1" (decimal 1)
        BigInteger sum, carry;

        //x.toString(2) will print binary string, 2 is radix
        System.out.printf("%d + %d = ", x, y);

        while (!y.equals(BigInteger.ZERO)) {
            sum = x.xor(y); // XOR addition without carry
            carry = x.and(y).shiftLeft(1); // AND + shift for carry

            x = sum;
            y = carry;
        }

        System.out.printf("%s", x);
    }
}
