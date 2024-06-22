package algorithms.Sorting;

import java.util.Arrays;

/**
* A sorting algorithm that builds a sorted array one element at a time by repeatedly picking the next element
* from the unsorted portion and inserting it into its correct position in the sorted portion.
*/
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Given Array:");
        System.out.println(Arrays.toString(arr));

        insertionSort(arr);

        System.out.println("\nSorted array:");
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr){
        int length = arr.length;
        int key, i;
        for(int j = 1; j < length ; j++) {
            key = arr[j];
            i = j-1;
            while(i >= 0 && arr[i] > key) {
                arr[i+1] = arr[i];
                arr[i--] = key;
            }
        }
    }
}
