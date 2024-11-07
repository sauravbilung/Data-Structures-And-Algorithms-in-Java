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

    public static int extractMax(int[] arr, int heapSize) {

        if (heapSize < 1) {
            throw new RuntimeException("Heap underflow");
        }

        int max = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;
        maxHeapify(arr, 0, heapSize);
        return max;
    }

    public static int extractMin(int[] arr, int heapSize) {

        if (heapSize < 1) {
            throw new RuntimeException("Heap underflow");
        }

        int min = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;
        minHeapify(arr, 0, heapSize);
        return min;
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

    public static void maxHeapIncreaseKey(int[] arr, int i, int newKey) {
        if (arr.length < 1) {
            throw new RuntimeException("Heap underflow!");
        }

        arr[i] = newKey;
        while (i > 0 && arr[(i - 1) / 2] < arr[i]) {
            swap(arr, (i-1) / 2, i);
            i = (i-1) / 2;
        }
    }

    public static void minHeapDecreaseKey(int[] arr, int i, int newKey) {
        if (arr.length < 1) {
            throw new RuntimeException("Heap underflow!");
        }

        arr[i] = newKey;
        while (i > 0 && arr[(i - 1) / 2] > arr[i]) {
            swap(arr, (i-1) / 2, i);
            i = (i-1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
