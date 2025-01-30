package patterns.fastAndSlowPointers;

import dataStructures.LinkedList.ListNode;
import dataStructures.LinkedList.ListNodeUtils;

public class _2_MiddleOftheSequenceInLL {

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6, 7};
        ListNode head = ListNodeUtils.createLinkedListWithCycle(values, 10);
        ListNodeUtils.printLinkedList(head, 10);
        System.out.printf("Middle node : %d", findMiddle(head).val);
    }

    private static ListNode findMiddle(ListNode head) {

        ListNode slow = head;

        if (slow != null) {
            ListNode fast = head.next; // to return first middle node
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
        }

        return slow;
    }
}
