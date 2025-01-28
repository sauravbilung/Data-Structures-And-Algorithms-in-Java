package patterns.miscellaneous;

public class _1_prefixsum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int n = arr.length;

        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int start = 4, end = 5;
        int rangeSum = (start > 0) ? prefixSum[end] - prefixSum[start - 1] : prefixSum[end];
        System.out.printf("Range sum(%d,%d) : %d", start, end, rangeSum);
    }
}
