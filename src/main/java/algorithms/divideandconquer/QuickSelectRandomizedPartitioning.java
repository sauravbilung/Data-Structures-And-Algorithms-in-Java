package algorithms.divideandconquer;

import java.util.Random;

public class QuickSelectRandomizedPartitioning {
    private static final Random random = new Random();

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 5, 9, 7, 1, 4, 6, 8};
        int k = 1; // Kth largest from end.
        System.out.printf("Kth largest element: %d", findKthLargest(nums, k));
    }

    private static int findKthLargest(int[] nums, int k) {
        int size = nums.length;
        return findKthLargest(nums, 0, size - 1, size - k);
    }

    private static int findKthLargest(int[] nums, int start, int end, int k) {
        // Assume start will always be lesser than or equal to end
        int pivot = randomizedPartition(nums, start, end);
        if (pivot > k) {
            return findKthLargest(nums, start, pivot - 1, k);
        } else if (pivot < k) {
            return findKthLargest(nums, pivot + 1, end, k);
        } else {
            return nums[pivot];
        }
    }

    private static int randomizedPartition(int[] arr, int start, int end) {
        int pivotIndex = start + random.nextInt(end - start + 1);
        swap(arr, pivotIndex, end);
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, ++i, end);
        return i;
    }

    private static void swap(int[] arr, int position1, int position2) {
        int temp = arr[position1];
        arr[position1] = arr[position2];
        arr[position2] = temp;
    }
}
