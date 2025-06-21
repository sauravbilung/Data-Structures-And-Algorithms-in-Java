package algorithms.dynamicprogramming.rollingWindow;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an array of non-negative integers where each element represents the amount of money
 * in a house, determine the maximum amount of money that can be robbed without robbing two
 * adjacent houses.
 **/
public class _1_HouseRobber {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter space separated number : ");
        int[] nums = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HouseRobberSolution solution = new HouseRobberSolution();
        System.out.printf("\nMax amount : %d", solution.rob(nums));
    }
}

class HouseRobberSolution {
    public int rob(int[] nums) {
        // understand like this :
        // robPrev is previous cell. dp[i-1]
        // robPrevPrev is storing the max that can be formed at dp[i-2]
        // We are only storing the last few states. Not maintaining the full dp[] array.
        int robPrev = 0, robPrevPrev = 0;

        for (int num : nums) {
            int current = Math.max(robPrev, robPrevPrev + num);
            robPrevPrev = robPrev;
            robPrev = current;
        }

        return robPrev;
    }
}

