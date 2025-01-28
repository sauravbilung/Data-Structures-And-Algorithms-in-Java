package dataStructures.LinkedList;

public class ListNodeUtils {

    public static ListNode createLinkedListWithCycle(int[] values, int cycleIndex) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        ListNode cycleNode = null;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;

            if (i == cycleIndex) {
                cycleNode = current;
            }
        }

        // creating cycle at the last node
        if (cycleIndex >= 0 && cycleNode != null) {
            current.next = cycleNode;
        }

        return head;
    }

    public static void printLinkedList(ListNode head, int limit) {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }

        ListNode current = head;
        int count = 0;

        while (current != null && count < limit) {
            System.out.printf("%d -> ", current.val);
            current = current.next;
            count++;
        }

        if (current != null) {
            System.out.println("....cycle detected or limit reached.");
        } else {
            System.out.println("End of linked list.");
        }
    }
}