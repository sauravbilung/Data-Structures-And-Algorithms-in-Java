package dataStructures.heaps.priorityQueueImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class _2_MaxHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(Arrays.asList(3, 9, 1, 5, 6, 3, 8, 0));
        maxHeap.add(10);
        System.out.println("Max heap : ");
        System.out.println(maxHeap);

        System.out.printf("\nMaximum element : %d", maxHeap.peek());
        System.out.printf("\nRemoving root : %d", maxHeap.poll());
        System.out.println("\nUpdated max heap : " + maxHeap);

        // Other heap operations
        // minHeap.remove(10); // Removes 10 from the heap if it exists
        // minHeap.size()
        // minHeap.isEmpty();
        // minHeap.clear();

        /*
        In Java's PriorityQueue, there isn’t a direct way to access or update elements
        at a specific position because it doesn’t expose the underlying array or allow indexed access as a typical array or list would.
        */
    }
}
