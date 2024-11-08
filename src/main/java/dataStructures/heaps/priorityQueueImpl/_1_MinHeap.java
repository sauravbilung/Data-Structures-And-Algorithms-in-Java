package dataStructures.heaps.priorityQueueImpl;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _1_MinHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Arrays.asList(3, 9, 1, 5, 6, 3, 8, 0, 10));
        System.out.println("Min heap :");
        System.out.println(minHeap);

        System.out.printf("\nMinimum element : %d", minHeap.peek());
        System.out.printf("\nRemoving root : %d", minHeap.poll());
        System.out.println("\nUpdated min heap :" + minHeap);

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
