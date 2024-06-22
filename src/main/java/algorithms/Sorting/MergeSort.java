package algorithms.Sorting;

import java.util.Arrays;

/**
Merge sort is a “divide and conquer” algorithm, wherein we first divide the problem into subproblems.
When the solutions for the subproblems are ready,we combine them together to get the final solution to the problem.

Divide: In this step, we divide the input array into 2 halves, the pivot being the midpoint of the array.
        This step is carried out recursively for all the half arrays until there are no more half arrays to divide.
Conquer: In this step, we sort and merge the divided arrays from bottom to top and get the sorted array.

*/

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Given Array:");
        System.out.println(Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array:");
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int arr[], int start, int end) {
         if(start < end){
             int mid = Math.floorDiv(start+end,2);
             mergeSort(arr, start, mid);
             mergeSort(arr, mid+1, end);
             merge(arr, start, mid, end);
         }
    }

    public static void merge(int[] arr, int start, int mid, int end){
       int sizeOfLeftArray = mid - start + 1;
       int sizeOfRightArray = end - mid;
       int[] leftArray = new int[sizeOfLeftArray];
       int[] rightArray = new int[sizeOfRightArray];

       for(int i = 0; i < sizeOfLeftArray; i++) {
           leftArray[i] = arr[start+i];
       }

       for(int j = 0; j < sizeOfRightArray; j++){
           rightArray[j] = arr[mid+j+1];
       }

       int i = 0, j = 0, k = start;
       while(i < sizeOfLeftArray && j < sizeOfRightArray){
         if(leftArray[i] <= rightArray[j]) {
             arr[k++] = leftArray[i++];
         } else {
             arr[k++] = rightArray[j++];
         }
       }

       while(i < sizeOfLeftArray){
           arr[k++] = leftArray[i++];
       }
       while(j < sizeOfRightArray){
           arr[k++] = rightArray[j++];
       }
    }
}
