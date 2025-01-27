package dataStructures.arrays.twopointerpattern;

import java.util.Arrays;

//same direction traversal of two pointers
public class _2_RemoveduplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0, 5, 4, 6, 5, 4, 8, 9, 0, 1, 1, 2, 3, 1, 4, 5, 6, 7, 12};
        Arrays.sort(nums);
        int newLengthOfArray = removeDuplicates(nums);
        Arrays.stream(nums).limit(newLengthOfArray).forEach(num -> System.out.print(num + " "));
    }

    private static int removeDuplicates(int[] nums) {
        int writePointer = 1;
        for (int readPointer = 1; readPointer < nums.length; readPointer++) {
            if (nums[readPointer] != nums[readPointer - 1]) {
                nums[writePointer] = nums[readPointer];
                writePointer++;
            }
        }
        return writePointer;
    }
}
