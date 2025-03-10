# Two's Complement for Signed Numbers

## 1. Why Use Two's Complement?
Two's complement is the most common method to represent signed integers in binary because:
- It allows simple addition & subtraction without special handling for negative numbers.
- The Most Significant Bit (MSB) determines the sign (0 for positive, 1 for negative).
- No duplicate representation of zero (0 is uniquely represented as `0000...0000`). In the one's complement system, `0000..0000` represents `+0` and `1111..1111` represents `-0`.

## 2. Representing Signed Numbers in Two's Complement

### Positive Numbers:
- Same as normal binary representation.
- Examples: `0000`, `0001`, `0010`, etc.

### Negative Numbers:
To represent a negative number in two's complement:
1. Write the absolute value in binary.
2. Find the one's complement (flip all bits: `0 → 1`, `1 → 0`).
3. Add `1` to get the final two’s complement representation.

#### Example:
For `-5`:
- Absolute value of `5` in binary: `0101`
- One's complement: `1010`
- Add `1`: `1010 + 1 = 1011`
- Final representation: `1011`

## 3. Range of Two's Complement
In an `n`-bit system, the range of numbers that can be represented using two’s complement is:
```
-(2^(n-1)) to (2^(n-1) - 1)
```

### Examples:
- **16-bit system:** Minimum: `-32,768`, Maximum: `32,767`
- **32-bit system:** Minimum: `-2,147,483,648`, Maximum: `2,147,483,647`

## 4. Why Two’s Complement Works for Arithmetic
In two’s complement, addition and subtraction work without extra logic.

#### Example:
```
  0101  (5)
+ 1101  (-3)
---------
  0010  (2)
```

## 5. Detecting Overflow in Two’s Complement
Overflow occurs when:
- Adding two positives results in a negative.
- Adding two negatives results in a positive.

#### Example of Overflow:
```
  0111  (7)
+ 0011  (3)
---------
  1010  (-6, incorrect due to overflow)
```
In this case, the result should be `10`, which exceeds the range for a 4-bit signed number.

---
This guide explains the fundamentals of two’s complement representation and arithmetic, which is crucial in computer systems and binary arithmetic operations.
