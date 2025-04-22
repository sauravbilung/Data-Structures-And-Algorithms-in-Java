package patterns.twopointerpattern;

import java.util.Arrays;

public class _5_RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums2 = {1, 2, 3, 4, 5};
        int[] nums3 = {1, 1, 1, 1, 1};
        int[] nums4 = {0,0,1,1,1,1,2,3,3};

        // elements are sorted in non-decreasing order and only two duplicates are allowed.
        Arrays.stream(nums).limit(removeDuplicates(nums)).forEach(a -> System.out.printf("%d ", a));
        System.out.println();
        Arrays.stream(nums2).limit(removeDuplicates(nums2)).forEach(a -> System.out.printf("%d ", a));
        System.out.println();
        Arrays.stream(nums3).limit(removeDuplicates(nums3)).forEach(a -> System.out.printf("%d ", a));
        System.out.println();
        Arrays.stream(nums4).limit(removeDuplicates(nums4)).forEach(a -> System.out.printf("%d ", a));

    }

    private static int removeDuplicates(int[] nums) {
        int insertPos = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[insertPos - 2]) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        return insertPos;
    }

    // O(nlogn) solution by marking positions and sorting.
    public int removeDuplicates2(int[] nums) {
        int marked = 0;
        int count = 1;
        int size = nums.length;
        int current = nums[0];
        for (int i = 1; i < size; i++) {

            if (current == nums[i])
                count++;
            else {
                current = nums[i];
                count = 1;
            }

            if (count > 2) {
                nums[i] = Integer.MAX_VALUE;
                marked++;
            }
        }

        Arrays.sort(nums);

        return size - marked;
    }
}
