package patterns.fastAndSlowPointers;

import dataStructures.LinkedList.ListNode;
import dataStructures.LinkedList.ListNodeUtils;

public class _1_cycledetectioninLL {

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6};
        int cycleIndex = 2;
        ListNode head = ListNodeUtils.createLinkedListWithCycle(values, cycleIndex);
        ListNodeUtils.printLinkedList(head, 10);
        System.out.printf("Has cycle ? : %b", hasCycle(head));
    }

    private static boolean hasCycle(ListNode head) {
        boolean hasCycle = false;
        if (head != null && head.next != null) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (fast == slow) {
                    hasCycle = true;
                    break;
                }
            }
        }
        return hasCycle;
    }
}
