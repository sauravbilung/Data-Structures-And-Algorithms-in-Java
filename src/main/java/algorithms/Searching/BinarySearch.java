package algorithms.Searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] sortedNums = {1, 3, 4, 6, 7, 8, 9, 14};
        int target = 9;
        int result = binarySearch(sortedNums, target);

        if (result == -1) {
            System.out.printf("Num %d not found.", target);
        } else {
            System.out.printf("Num %d found at position : %d", target, result);
        }
    }

    private static int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int position = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                position = mid;
                break;
            }
        }
        return position;
    }
}
