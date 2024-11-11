package algorithms.divideandconquer;

/**
 * Quickselect is a selection algorithm to find the k-th smallest element in an unordered list. It is related to the quick sort sorting algorithm.
 */
public class Quickselect {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 5, 9, 7, 1, 4, 6, 8};
        //int[] nums = new int[]{7, 10, 4, 3, 20, 15};
        int k = 3; // KthSmallest starting from 1.
        System.out.printf("Kth smallest element : %d", findKthSmallest(nums, k));
    }

    private static int findKthSmallest(int[] nums, int k) {
        return findKthSmallest(nums, 0, nums.length - 1, k - 1);
    }

    private static int findKthSmallest(int[] nums, int start, int end, int k) {
        // Assume start will always be lesser than or equal to end
        int pivot = partition(nums, start, end);
        if (pivot > k) {
            return findKthSmallest(nums, start, pivot - 1, k);
        } else if (pivot < k) {
            return findKthSmallest(nums, pivot + 1, end, k);
        } else {
            return nums[pivot];
        }
    }

    private static int partition(int[] arr, int start, int end) {
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
