package patterns.monotonicqueue.slidingWindow;

import java.util.*;

public class _2_SlidingWindowMedian {

    public static void main(String[] args) {

        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7}; // expected output : [1,-1,-1,3,5,6] for k= 3
        int[] nums2 = {2147483647, 2147483647};
        int[] nums3 = {9, 7, 0, 3, 9, 8, 6, 5, 7, 6}; //expected output : [7,3,3,8,8,6,6,6] for k = 3
        int[] nums4 = {1}; //k =1
        int[] nums5 = {1, 2}; // expected output : [1,2] for k=1
        int[] nums6 = {7, 8, 8, 3, 8, 1, 5, 3, 5, 4}; // expected output : [8.0, 8.0, 8.0, 3.0, 5.0, 3.0, 5.0, 4.0] for k=3
        System.out.printf("%s, output = %s\n", Arrays.toString(nums1), Arrays.toString(getMedianSlidingWindow(nums1, 3)));
        System.out.printf("%s, output = %s\n", Arrays.toString(nums2), Arrays.toString(getMedianSlidingWindow(nums2, 2)));
        System.out.printf("%s, output = %s\n", Arrays.toString(nums3), Arrays.toString(getMedianSlidingWindow(nums3, 3)));
        System.out.printf("%s, output = %s\n", Arrays.toString(nums4), Arrays.toString(getMedianSlidingWindow(nums4, 1)));
        System.out.printf("%s, output = %s\n", Arrays.toString(nums5), Arrays.toString(getMedianSlidingWindow(nums5, 1)));
        System.out.printf("%s, output = %s\n", Arrays.toString(nums6), Arrays.toString(getMedianSlidingWindow(nums6, 3)));
    }

    public static double[] getMedianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1]; // nums.length - (k-1)
        //If values at indices are equal then we break tie by the smaller index.
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
        // left - right means we are storing smaller values than median to left and
        // greater than median to the right.
        TreeSet<Integer> left = new TreeSet<>(comparator.reversed()); // max heap
        TreeSet<Integer> right = new TreeSet<>(comparator); // min heap

        for (int i = 0; i < nums.length; i++) {

            // remove values out of window from the heap
            // if k=3 and i=3 then we remove i-k=0.
            // The window considers element at indices (1,2,3).
            if (i >= k) {
                if (!right.remove(i - k)) {
                    left.remove(i - k);
                }
            }

            // insert into correct heap
            if (left.isEmpty() || nums[i] <= nums[left.first()]) {
                left.add(i);
            } else {
                right.add(i);
            }

            // balancing heaps before finding median
            // - For even k, both heaps have the same number of elements.
            // - For odd k, left has one more element than left.
            balanceDataSizeInHeaps(left, right);
            // If we have processed at least k elements then we find the median.
            if (i >= k - 1) {
                result[i - k + 1] = findMedian(left, right, k, nums); // i-(k-1)
            }
        }

        return result;
    }

    private static void balanceDataSizeInHeaps(TreeSet<Integer> left, TreeSet<Integer> right) {
        while (right.size() > left.size()) {
            left.add(right.pollFirst());
        }

        while (left.size() - right.size() > 1) {
            right.add(left.pollFirst());
        }
    }

    private static double findMedian(TreeSet<Integer> left, TreeSet<Integer> right, int k, int[] nums) {
        double result;
        if (k % 2 == 0) {
            result = ((long) nums[left.first()] + nums[right.first()]) / 2.0;
        } else {
            result = nums[left.first()];
        }

        return result;
    }
}
/**
 * Summary :
 * <p>
 * Using Two Heaps: They allow the algorithm to split the current sliding window into two halves—one containing the smaller numbers
 * and the other containing the larger numbers—so that the median can be computed quickly (in constant time) from the top elements of these heaps.
 * <p>
 * Balancing: The balancing step ensures that after each insertion (or removal), the two halves remain of nearly equal size (or with the left
 * having one extra element if the window size is odd). This invariant is crucial because it guarantees that the median is always available directly from the heaps.
 */