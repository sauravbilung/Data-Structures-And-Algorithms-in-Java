package algorithms.Sorting;


import java.util.Arrays;

/**
 * Selection Sort starts by finding the smallest element in an unsorted array and swaps it with the element at the first position.
 * It then moves to the second position, finds the second smallest element, and swaps it with the element at the second position.
 * This process continues until the array is sorted. To sort in descending order, find the largest element instead of the smallest.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Given Array:");
        System.out.println(Arrays.toString(arr));

        selectionSort(arr);

        System.out.println("\nSorted array:");
        System.out.println(Arrays.toString(arr));
    }
    private static void selectionSort(int[] arr) {
        int n = arr.length;
        int i, j, min_idx;
        for (i = 0; i < n - 1; i++) {
            min_idx = i;
            for (j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            }
            swap(arr, i, min_idx);
        }
    }

    private static void swap(int[] arr, int position1, int position2) {
        int temp = arr[position1];
        arr[position1] = arr[position2];
        arr[position2] = temp;
    }
}
