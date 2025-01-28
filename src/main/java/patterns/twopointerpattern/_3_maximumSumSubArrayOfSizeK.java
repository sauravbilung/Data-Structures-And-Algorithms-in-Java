package patterns.twopointerpattern;

// Two pointers sliding window approach
public class _3_maximumSumSubArrayOfSizeK {

    public static void main(String[] args) {
        int[] nums = {2, 3, 8, 0, 5, 4, 1, 8, 4, 0};

        int maxSum = 0, windowSum = 0;
        int k = 4; // window size
        for (int i = 0; i < nums.length; i++) {
            windowSum += nums[i];
            if (i >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                // Slide the window forward by removing the first element.
                windowSum -= nums[i - (k - 1)];
            }
        }

        System.out.printf("Maximum subarray of size %d : %d", k, maxSum);
    }
}
