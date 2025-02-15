package patterns.monotonicstack.ngep;

import java.util.*;

public class _3_NextGreaterElement1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {4, 1, 2}; // Find next greater element for these numbers
        int[] nums2 = {3, 1, 4, 2}; // Search for next greater elements from this array

        System.out.printf("Original array: %s\n", Arrays.toString(nums2));
        System.out.printf("NGE for %s : %s\n", Arrays.toString(nums1), Arrays.toString(solution.nextGreaterElement(nums1, nums2)));
    }
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>(); // monotonic decreasing stack.

        // Build the Next Greater Element mapping
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // Fill the result array for nums1 based on the precomputed map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}
