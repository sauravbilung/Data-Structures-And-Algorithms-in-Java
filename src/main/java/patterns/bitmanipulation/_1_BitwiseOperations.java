package patterns.bitmanipulation;

import java.util.*;

public class _1_BitwiseOperations {

    public static void main(String... args) {
        //System.out.printf("Is %d odd ? : %b", 3, isOdd(3));
        //swap(3, 4);
        //System.out.printf("\nIs %d  power of two ? : %b", 64, isPowerOfTwo(64));
        //System.out.printf("\n Number of set bits in %d : %d", 15, countSetBits(15));
        //findUnique();
        //findTwoUniques();
        //missingNumber();
        //reverseBits();
        //rightmostSetBit();
        //logBase2();
        //printSubsets();
        findMaximumXOR();
    }

    public static boolean isOdd(int x) {
        // The last bit of an odd number is always 1.
        // 1 is 0000...0001  (32-bit integer representation)
        return (x & 1) == 1;
    }

    public static void swap(int a, int b) {
        // A XOR A = 0
        // A XOR 0 = A
        // A XOR B XOR B = A
        System.out.printf("\nBefore swap a=%d , b=%d", a, b);
        a = a ^ b;
        b = a ^ b; // b = (a ^ b) ^ b
        a = a ^ b; // a = (a ^ b) ^ a ; b = a after step 2.
        System.out.printf("\nAfter swap a=%d, b=%d", a, b);
    }

    public static boolean isPowerOfTwo(int x) {
        // Powers of 2 have only 1 bit set. Eg - 8 (1000)
        // x - 1 flips all the bits after the rightmost 1 in x
        // Eg - (8-1) = 7 (0111)
        return (x > 0) && (x & (x - 1)) == 0;
    }

    public static int countSetBits(int x) {
        // At every iteration we remove the rightmost 1. (Lowest set bit)
        // 13 = 1101 , 13-1 = 1100 , 13 & 12 = 1100 (12)
        // 12 = 1100 , 11 = 1011, 12 & 11 = 1000 (8)
        // 8 = 1000, 10 = 0111 , 11 & 10 = 0000 (0)
        // Simply, Integer.bitCount(x)
        int count = 0;
        while (x > 0) {
            x = x & (x - 1);
            count++;
        }
        return count;
    }

    public static void findUnique() {
        // Assumes all repeating numbers appear exactly twice
        int[] nums = {5, 5, 6, 5, 4, 5, 4};
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        System.out.printf("Find unique %s : %d", Arrays.toString(nums), xor);
    }

    public static void findTwoUniques() {
        // explanation below
        int[] nums = {5, 5, 4, 9, 6, 6};
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int rightmostBit = xor & -xor;
        int x = 0, y = 0;

        for (int num : nums) {
            if ((num & rightmostBit) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        System.out.printf("Find two uniques %s : [%d, %d]", Arrays.toString(nums), x, y);
    }

    public static void missingNumber() {
        int[] nums = {7, 8, 10, 11, 12};
        int xor = 0;

        for (int i = 7; i <= 12; i++) {
            xor ^= i;
        }
        for (int num : nums) {
            xor ^= num;
        }

        System.out.printf("Missing number in %s : %d", Arrays.toString(nums), xor);
    }

    public static void reverseBits() {
        int x = 13;

        // Print x in 32-bit format
        System.out.printf("%d in bits  : %s\n", x,
                String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0'));

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (x & 1);
            x >>= 1;
        }

        // Print the reversed bits in 32-bit format
        System.out.printf("Reversed  : %s (%d)\n",
                String.format("%32s", Integer.toBinaryString(result)).replace(' ', '0'),
                result);
    }

    public static void rightmostSetBit() {
        int x = 10;

        // Print x in 32-bit format
        System.out.printf("%d in bits  : %s\n", x,
                String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0'));

        // Compute rightmost set bit
        int result = x & -x;

        // Corrected print statement
        System.out.printf("Rightmost set bit for %d : %d (Binary: %s)\n",
                x, result, String.format("%32s", Integer.toBinaryString(result)).replace(' ', '0'));
    }

    public static void logBase2() {
        // log2(x) = log(x) / log(2)
        int x = 64;
        int logBase2Forx = (int) (Math.log(x) / Math.log(2));
        System.out.printf("Number :%d, LogBase2 : %d", x, logBase2Forx);
    }

    public static void printSubsets() {
        // explanation below
        // key idea : The n-bit number represents a subset.
        int[] nums = {1, 2, 3};
        int n = nums.length;
        System.out.printf("Given array : %s\n", Arrays.toString(nums));
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }

            System.out.println(subset);
        }
    }

    public static void findMaximumXOR() {
        int[] nums = {3, 10, 5, 25, 2, 8};
        int maxXor = 0, mask = 0;
        Set<Integer> prefixes = new HashSet<>();

        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            prefixes.clear();
            for (int num : nums) {
                prefixes.add(num & mask);
            }

            int candidateXOR = maxXor | (1 << i);
            for (int prefix : prefixes) {
                if (prefixes.contains(prefix ^ candidateXOR)) {
                    maxXor = candidateXOR;
                    break;
                }
            }
        }
        System.out.printf("Array : %s , maximum xor : %d", Arrays.toString(nums), maxXor);
    }

}

// Note :

/*
Basic bitwise operations :
AND (&): x & y → Extracting bits
OR (|): x | y → Setting bits
XOR (^): x ^ y → Toggle bits, checking odd/even
NOT (~): ~x → Inverting bits
Left Shift (<<): x << n → Multiply by 2^n
Right Shift (>>): x >> n → Divide by 2^n
Unsigned Right Shift (>>>): Logical right shift
*/

/*
 * Properties :
 * 1. A ⊕ B = C ⇒ B ⊕ C = A and A ⊕ C = B
 * 2. x | (1 << n) sets the n-th bit.
 * 3. x ^ (1 << n) toggles the n-th bit.
 * 4. ~x = -(x+1) in 2’s complement representation. Eg : ~0 = -1, ~1 = -2
 * 5. x << n shifts bits left by n places, filling the rightmost bits with 0, which may change the sign if overflow occurs, and is equivalent to x * 2^n.
 * 6. x >> n shifts bits right by n places, filling the leftmost bits with the sign bit (0 for positive, 1 for negative), preserving the number's sign, and is equivalent to x / 2^n.
 * 7. x >>> n shifts bits right by n places, always filling the leftmost bits with 0, treating the value as unsigned (ignoring sign), and is equivalent to x / 2^n for positive numbers but not for negative numbers.
 * 8. Checking if a number is power of 2 : (x & (x - 1)) == 0
 * 9. Finding the lowest set bit : x & -x
 * */

// Rightmost bit - Usually refers to LSB (Least Significant Bit)
// rightmost set bit - Refers to the lowest set bit (1) on the right.

/*
Trick for Finding Two Unique Numbers:

1. Computing `xor`:
   - XORing all numbers cancels out the duplicate numbers (since `a ⊕ a = 0`).
   - The final `xor` result represents `num1 ⊕ num2`, where `num1` and `num2` are the two unique numbers.

2. Extracting the Rightmost Set Bit:
   - In binary, the `1`s in `xor` indicate the positions where `num1` and `num2` differ.
   - The rightmost `1` in `xor` represents the **first differing bit** between `num1` and `num2`.
   - Computing `-xor` (two's complement) inverts all bits up to the first `1` and keeps that `1` isolated.
   - Performing `xor & -xor` zeros out all other bits, leaving only the **lowest differing bit**.

    Example:
      xor   =  0000 0110   (6 in binary)
     -xor   =  1111 1010   (-6 in binary, two’s complement)
    ----------------------
    xor & -xor =  0000 0010   (binary) → 2 (decimal)

3. Grouping and Finding the Unique Numbers:
   - Using `xor & -xor`, we partition numbers into two groups:
     - **Group 1:** Numbers where the differing bit is `0`
     - **Group 2:** Numbers where the differing bit is `1`
   - XORing within each group cancels out duplicates, leaving only the two unique numbers.

This approach efficiently finds the two unique numbers in **O(n) time and O(1) space**.
*/

/*
 * Trick to generate and print all subsets of a set using bit manipulation.
 *
 * - If the set contains `n` elements, the total number of subsets is `2^n`.
 * - For example, if the set is {1, 2, 3}, then the total subsets will be `2^3 = 8`,
 *   represented by binary values from `000` to `111`.
 *
 * - Each binary number (`mask`) represents a subset:
 *   - `000` → Empty subset `[]` (include no elements)
 *   - `001` → Include only the 3rd element `[3]`
 *   - `010` → Include only the 2nd element `[2]`
 *   - `011` → Include 2nd and 3rd elements `[2, 3]`
 *   - `111` → Include all elements `[1, 2, 3]`
 *
 * - The `i-th` bit of `mask` determines whether to include `nums[i]` in the subset:
 *   - If `mask & (1 << i) != 0`, include `nums[i]`
 *   - Otherwise, exclude `nums[i]`
 *
 * - This approach efficiently generates all subsets without recursion.
 */


/*
  Trick for Finding Maximum XOR of Two Numbers:

  1. **Using a Prefix Set for Efficient Lookup**
     - We extract **prefixes** of all numbers using a mask (`mask |= (1 << i)`).
     - The prefix of a number is its **top i bits**.
     - These prefixes help us check if a certain XOR value is possible.

  2. **Building the Maximum XOR from MSB to LSB**
     - We **start from the most significant bit (MSB)** and move towards the least.
     - At each step, we **assume** we can set the `i`-th bit in `maxXOR`.
     - We then check if there exist **two numbers in the array whose XOR equals this assumption**.

  3. **Checking If a Candidate XOR is Possible**
     - If we assume `maxXOR | (1 << i)`, we need to verify if there exist two prefixes `A` and `B` such that:
         ```
         A ^ B = candidateXOR
         ```
     - Using the property of XOR: `A ^ B = C  ⟹  B = A ^ C`
     - If `prefix ^ candidateXOR` exists in `prefixes`, then **this bit can be part of maxXOR**.

  4. **Greedy Approach to Maximize XOR**
     - We **try to keep as many 1s as possible** in `maxXOR`.
     - If the bit can be set, we keep it; otherwise, we move to the next lower bit.

     **Time Complexity:** O(N)
     **Space Complexity:** O(N)
  */

