package dataStructures.heaps;

public class HeapUtils {

    public enum HeapType {MAX, MIN}

    public static void buildHeap(int[] arr, HeapType heapType) {
        int heapSize = arr.length;
        int firstNonLeafNodePosition = heapSize / 2 - 1;
        for (int i = firstNonLeafNodePosition; i >= 0; i--) {
            if (heapType == HeapType.MAX) {
                maxHeapify(arr, i, heapSize);
            } else {
                minHeapify(arr, i, heapSize);
            }
        }
    }


    public static void maxHeapify(int[] arr, int i, int heapSize) {
        int left = 2 * i + 1;
        int right = left + 1, largest = i;
        if (left < heapSize && arr[left] > arr[i]) {
            largest = left;
        }

        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest, heapSize);
        }
    }

    public static void minHeapify(int[] arr, int i, int heapSize) {
        int left = 2 * i + 1;
        int right = left + 1, smallest = i;
        if (left < heapSize && arr[i] > arr[left]) {
            smallest = left;
        }
        if (right < heapSize && arr[smallest] > arr[right]) {
            smallest = right;
        }

        if (smallest != i) {
            swap(arr, i, smallest);
            minHeapify(arr, smallest, heapSize);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
