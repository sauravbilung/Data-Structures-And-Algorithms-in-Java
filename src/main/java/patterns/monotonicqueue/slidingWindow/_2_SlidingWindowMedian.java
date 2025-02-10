package patterns.monotonicqueue.slidingWindow;

import java.util.*;

public class _2_SlidingWindowMedian {

    public static void main(String[] args) {

        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7}; // expected output : [1,-1,-1,3,5,6] for k= 3
        int[] nums2 = {2147483647, 2147483647};
        int[] nums3 = {9, 7, 0, 3, 9, 8, 6, 5, 7, 6}; //expected output : [7,3,3,8,8,6,6,6] for k = 3
        int[] nums4 = {1}; //k =1
        int[] nums5 = {1, 2}; // expected output : [1,2] for k=1
        int[] nums6 = {7, 8, 8, 3, 8, 1, 5, 3, 5, 4}; // expected output : [8,8,8,3,8,1,5,3,5,4] for k=3
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
        TreeSet<Integer> minHeap = new TreeSet<>(comparator); // min heap
        TreeSet<Integer> maxHeap = new TreeSet<>(comparator.reversed()); // max heap

        for (int i = 0; i < nums.length; i++) {

            // remove values out of window from the heap
            // if k=3 and i=3 then we remove i-k=0.
            // The window considers element at indices (1,2,3).
            if (i >= k) {
                if (!minHeap.remove(i - k)) {
                    maxHeap.remove(i - k);
                }
            }

            minHeap.add(i);
            maxHeap.add(minHeap.pollFirst());

            // balancing heaps before finding median
            // - For even k, both heaps have the same number of elements.
            // - For odd k, minHeap has one more element than maxHeap.
            balanceDataSizeInHeaps(minHeap, maxHeap);

            // If we have processed at least k elements then we find the median.
            if (i >= k - 1) {
                result[i - k + 1] = findMedian(minHeap, maxHeap, k, nums); // i-(k-1)
            }
        }

        return result;
    }

    private static void balanceDataSizeInHeaps(TreeSet<Integer> minHeap, TreeSet<Integer> maxHeap) {
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.pollFirst());
        }
    }

    private static double findMedian(TreeSet<Integer> minHeap, TreeSet<Integer> maxHeap, int k, int[] nums) {
        double result;
        if (k % 2 == 0) {
            result = ((long) nums[minHeap.first()] + nums[maxHeap.first()]) / 2.0;
        } else {
            result = nums[minHeap.first()];
        }

        return result;
    }
}
/**
 * Summary :
 *
 * Using Two Heaps: They allow the algorithm to split the current sliding window into two halves—one containing the smaller numbers
 * and the other containing the larger numbers—so that the median can be computed quickly (in constant time) from the top elements of these heaps.
 *
 * Balancing: The balancing step ensures that after each insertion (or removal), the two halves remain of nearly equal size (or with the minHeap
 * having one extra element if the window size is odd). This invariant is crucial because it guarantees that the median is always available directly from the heaps.
 */