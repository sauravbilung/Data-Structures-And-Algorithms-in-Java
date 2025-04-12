package patterns.monotonicqueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


public class _1_SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = {1, 3, 1, 2, 0, 5};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
        // Output: [3, 3, 5, 5, 6, 7]
        System.out.println(Arrays.toString(maxSlidingWindow(nums2, k)));
        // Output : [3, 3, 2, 5]
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        // We store the indices of elements in the nums array to efficiently manage window boundaries.

        if (nums == null || nums.length == 0) return new int[0];

        // The first window starts at index 0 and ends at k - 1.
        // Example: For k = 3, the initial window covers indices (0,1,2).
        int n = nums.length;
        int[] result = new int[n - (k - 1)];
        Deque<Integer> deque = new LinkedList<>();  // Monotonic Decreasing Queue

        for (int i = 0; i < n; i++) {
            // Remove elements from the front of the deque if they are out of the current window.
            // Example: If i = 3, then i - (k - 1) = 1, meaning index 0 should be removed.
            // The window now considers indices (1,2,3).
            if (!deque.isEmpty() && deque.peekFirst() < i - (k - 1)) {
                deque.pollFirst();
            }

            // Maintain decreasing order in deque by removing smaller elements from the back.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current element's index to deque
            deque.offerLast(i);

            // Store the maximum of the current window once we reach index i >= k - 1.
            if (i >= k - 1) {
                result[i - (k - 1)] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}


