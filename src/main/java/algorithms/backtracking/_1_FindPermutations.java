package algorithms.backtracking;

import java.util.*;

/**
 * Finding all permutations of a given string
 * Link : https://leetcode.com/problems/permutations/description/
 */
public class _1_FindPermutations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter space separated numbers :");
        String input = scanner.nextLine();
        int[] nums = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

        List<List<Integer>> allPermutations = permute(nums);
        allPermutations.forEach(System.out::println);
    }

    /**
     * Method signature as per leetcode.
     **/
    static public List<List<Integer>> permute(int[] nums) {
        List<Integer> input = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        List<List<Integer>> result = new ArrayList<>();
        generateAllPermutations(input, 0, nums.length-1, result);
        return result;
    }

    public static void generateAllPermutations(List<Integer> nums, int start, int end, List<List<Integer>> result) {

        if(start == end) {
            result.add(new ArrayList<>(nums));
        }
        else {
            for(int index=start; index<=end; index++) {
                Collections.swap(nums, start, index);
                generateAllPermutations(nums, start+1, end, result);
                Collections.swap(nums, start, index);
            }
        }
    }
}
