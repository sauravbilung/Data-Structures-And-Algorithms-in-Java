package dataStructures.set;

import java.util.*;

public class _2_IntersectionOfArrays {

    public static void main(String[] args) {
        int[][] nums = {{3, 1, 2, 4, 5}, {1, 2, 3, 4}, {3, 4, 5, 6}};
        IntersectionOfArraysSolution solution = new IntersectionOfArraysSolution();
        System.out.println(solution.intersection(nums));
    }
}

class IntersectionOfArraysSolution {
    public List<Integer> intersection(int[][] nums) {
        Set<Integer> intersection = new HashSet<>();
        for (int num : nums[0]) {
            intersection.add(num);
        }

        for (int i = 1; i < nums.length; i++) {
            Set<Integer> currentSet = new HashSet<>();
            for (int num : nums[i]) {
                currentSet.add(num);
            }
            intersection.retainAll(currentSet); // Intersect sets
        }

        List<Integer> result = new ArrayList<>(intersection);
        Collections.sort(result);
        return result;
    }
}

