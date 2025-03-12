package patterns.bitmanipulation;

public class _2_AddBinary {
    public static void main(String... args) {
        int x = 5, y = 7;
        int sum, carry;
        System.out.printf("%d + %d = ", x, y);

        while (y != 0) {
            sum = x ^ y; // XOR addition without carry
            carry = (x & y) << 1; // AND + shift; moving the carry to appropriate position to add again
            x = sum;
            y = carry;
        }

        System.out.printf("%d", x);
    }
}

/*
 * Explanation:
 * Binary representation:
 * x = 5  ->  101
 * y = 7  ->  111
 *
 * Step 1:
 * Sum   =  101 XOR 111  = 010
 * Carry = (101 AND 111) << 1 = 1010
 *
 * Step 2:
 * Sum   =  010 XOR 1010  = 1000
 * Carry = (010 AND 1010) << 1 = 0100
 *
 * Step 3:
 * Sum   =  1000 XOR 0100  = 1100
 * Carry = (1000 AND 0100) << 1 = 0000
 *
 * Since carry is 0, the final result is 1100 (decimal 12)
 *
 * The while loop continues until carry becomes 0, ensuring all bits are properly added.
 */