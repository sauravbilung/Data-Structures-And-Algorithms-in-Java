package patterns.monotonicstack.rangeQueries;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _1_SumOfSubArrayMinimums {

    public static void main(String[] args) {
        int[] nums1 ={3,1,2,4}; // 17
        int[] nums2 = {3,1,1,2,4}; // 22
        int[] nums3 = {71,55,82,55}; // 593
        int[] nums4 = {2,2,2,2}; // 20
        int[] nums5 = {1,2,3,4}; // 20

        System.out.printf("%s, output : %d \n", Arrays.toString(nums1), sumSubarrayMins(nums1));
        System.out.printf("%s, output : %d \n", Arrays.toString(nums2), sumSubarrayMins(nums2));
        System.out.printf("%s, output : %d \n", Arrays.toString(nums3), sumSubarrayMins(nums3));
        System.out.printf("%s, output : %d \n", Arrays.toString(nums4), sumSubarrayMins(nums4));
        System.out.printf("%s, output : %d \n", Arrays.toString(nums5), sumSubarrayMins(nums5));

    }

    private static int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;

        int[] ple = new int[arr.length]; // i - pleIndex
        int[] nle = new int[arr.length]; // nleIndex - i

        // Finding previous lower elements
        for (int i = 0; i < arr.length; i++) {
            // > Stops at equal elements because previous elements should be counted together.
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            ple[i] = stack.isEmpty() ? i - (-1) : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Finding next lower elements
        for (int i = arr.length - 1; i >= 0; i--) {
            // >= Removes equal elements because they interfere with finding the correct boundary for future elements.
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            nle[i] = stack.isEmpty() ? arr.length - i : stack.peek() - i;
            stack.push(i);
        }

        for (int i = 0; i < arr.length; i++) {
            sum = (int)((sum + (long)arr[i] * ple[i] * nle[i]) % MOD);
        }

        return sum;
    }
}


/*
PLE - Previous less element - How far left this element(A[i]) can extend while still being the minimum.
NLE - next less element - How far right this element(A[i]) can extend while still being the minimum.

The contribution of A[i] as the minimum in subarrays is determined by:
Contribution = 𝐴[i] × Count of subarrays where A[i] is minimum

The number of subarrays where A[i] is the minimum : (i-PLE[i])×(NLE[i]-i)
So the total sum :
        i=0
        ∑ A[i]×(Distance to left)×(Distance to right)   in other words   [sum(A[i] * PLE * NLE) for each i]
        N−1

PLE distance = i - index of PLE, if there is no smaller element on the left, we set PLE index to -1.
NLE distance = index of NLE - i, if there is no smaller element on the right, we set NLE index to N (N is the length of array).

Index	Element	    PLE Distance	 NLE Distance	Total Subarrays Where This is Minimum
0	      3           1 [0 -(-1)]      1 [4-3]             1 × 1 = 1 → [3]
1	      1	          2 [1-(-1)]	   3 [4-1]             2 × 3 = 6 → [1], [1,2], [1,2,4], [3,1], [3,1,2], [3,1,2,4]
2	      2	          1	[2-1]          2 [4-2]             1 × 2 = 2 → [2], [2,4]
3	      4	          1	[3-2]          1 [4-3]             1 × 1 = 1 → [4]

For A[1] = 1, PLE distance is 2. It means value 1 is minimum in the subarrays that ends at value 1, extending at most 2 steps left.
valid subarrays = [1],[3,1]
For A[1] = 1, NLE distance is 3. It means value is minimum in the subarrays that starts at value 1, extending at most 3 steps right.
valid subarrays = [1],[1,2],[1,2,4]

We can combine PLE and NLE to get other sub-arrays. [3,1] and [1,2] to get [3,1,2]. [3,1] and [1,2,4] to get [3,1,2,4]
so total 6 (PLE * NLE) sub arrays for A[1] which are [1],[3,1],[1,2],[1,2,4],[3,1,2],[3,1,2,4].

How does monotonous increasing stack helps in PLE calculation ?
PLE (Previous Less Element) finds the closest smaller element to the left of an element.
1. We process the array from left to right.
2. If an element is smaller than the top of the stack, pop the stack (because it's no longer useful).
3. The top of the stack (after popping) gives us the index of the closest smaller element.
4. If the stack is empty, it means no smaller element exists before this element.

How does monotonous increasing stack helps in NLE calculation ?
NLE (Next Less Element) finds the closest smaller element to the right of an element.
1. We process the array from right to left.
2. If an element is smaller than the top of the stack, pop the stack (because it’s no longer useful).
3. The top of the stack (after popping) gives us the index of the closest smaller element to the right.
4. If the stack is empty, it means no smaller element exists after this element → Assume it extends to the end.

Important :
PLE: Why Stop at an Equal Element?
1.We are looking backward for the first smaller element.
2.If we find an equal element, it means that element has already been processed and is contributing to earlier subarrays.
3.We stop because equal elements on the left should be considered as part of the previous group rather than being popped.
4. This ensures PLE distances are correct (i.e., the contribution from left is correctly counted).

Example :
Consider arr = [3, 1, 1, 2, 4]
When processing arr[2] = 1, we find arr[1] = 1.

We stop at arr[1] because it is already counted in the previous subarrays.
We don't need to look further left because anything smaller has already influenced arr[1].
✅ Stopping at equal elements maintains proper subarray contribution.

NLE: Why Remove Equal Elements?
1.We are looking forward for the first smaller element.
2.If we find an equal element, we pop it because it cannot be the next less element.
3.We must continue looking forward because an equal element does not give us the correct boundary for the right side.
4.If we don’t remove it, it might incorrectly become the NLE for multiple elements.

Example:
Consider arr = [3, 1, 1, 2, 4].
When processing arr[1] = 1, we check arr[2] = 1:

If we don’t remove arr[2] = 1, it would incorrectly act as the next less element.
By removing it, we ensure that the next truly smaller element (which is N or 2) is found.
✅ Removing equal elements ensures that every element has a proper right boundary.

*/