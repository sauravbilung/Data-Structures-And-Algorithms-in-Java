package dataStructures.arrays.twopointerpattern;

// Two pointers from opposite side
public class _4_FindPairsWithAGivenSumInSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int targetSum = 10;
        findPairWithGivenSum(nums, targetSum);
    }

    private static void findPairWithGivenSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        boolean found = false;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                found = true;
                System.out.printf("\nPair found : %d + %d = %d", nums[left], nums[right], target);
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        if (!found) {
            System.out.printf("No pairs with the sum %d were found", target);
        }
    }
}
