package patterns.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class _7_SubsetSumProblem {
    public static void main(String[] args) {
        System.out.println("Enter space separated array contents : ");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Enter sum : ");
        int sum = scanner.nextInt();
        System.out.printf("Subset with sum %d exists ? : %b", sum, isSubsetSum(nums, sum));
    }

    private static Boolean isSubsetSum(int[] arr, int sum) {
        boolean result = false;
        if (doesPrerequisitesPass(arr, sum)) {
            result = doesSubsetSumExists(arr, 0, sum, 0);
        }
        return result;
    }

    private static boolean doesSubsetSumExists(int[] arr, int index, int sum, int currentSum) {
        boolean doesSubsetSumExists = false;
        if (currentSum == sum) {
            doesSubsetSumExists = true;
        } else if (currentSum < sum && index < arr.length) {
            doesSubsetSumExists = doesSubsetSumExists(arr, index + 1, sum, currentSum + arr[index]);
            if (!doesSubsetSumExists) {
                doesSubsetSumExists = doesSubsetSumExists(arr, index + 1, sum, currentSum);
            }
        }
        return doesSubsetSumExists;
    }

    private static boolean doesPrerequisitesPass(int[] nums, int sum) {
        boolean isZeroPossible = false, isNegativeSumPossible = false, isPositiveSumPossible = false;

        for (int num : nums) {
            isNegativeSumPossible = num < 0 || isNegativeSumPossible;
            isPositiveSumPossible = num > 0 || isPositiveSumPossible;
            isZeroPossible = num == 0 || isZeroPossible || (isNegativeSumPossible && isPositiveSumPossible);


            if ((sum == 0 && isZeroPossible) || (sum < 0 && isNegativeSumPossible) || (sum > 0 && isPositiveSumPossible)) {
                break;
            }
        }
        return isZeroPossible || isNegativeSumPossible || isPositiveSumPossible;
    }
}
