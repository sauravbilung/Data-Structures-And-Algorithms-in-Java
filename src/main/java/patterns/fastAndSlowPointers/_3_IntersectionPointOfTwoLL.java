package patterns.fastAndSlowPointers;

import dataStructures.LinkedList.ListNode;
import dataStructures.LinkedList.ListNodeUtils;

import java.util.Optional;

public class _3_IntersectionPointOfTwoLL {

    public static void main(String[] args) {
        int[] values1 = {10};
        int[] values2 = {3, 6, 9};
        int[] commonValues = {11, 22};
        ListNode commonListHead = ListNodeUtils.createLinkedListWithCycle(commonValues, -1);
        ListNode head1 = ListNodeUtils.createLinkedListWithCycle(values1, -1);
        ListNode head2 = ListNodeUtils.createLinkedListWithCycle(values2, -1);
        attachTail(head1, commonListHead);
        attachTail(head2, commonListHead);

        Optional<ListNode> intersectionNode = Optional.ofNullable(findIntersection(head1, head2));

        if (intersectionNode.isPresent()) {
            System.out.printf("Intersection point : %d", intersectionNode.get().val);
        } else {
            System.out.println("Intersection point is not present.");
        }
    }

    private static ListNode findIntersection(ListNode head1, ListNode head2) {
        ListNode p1 = head1;
        ListNode p2 = head2;

        while (p1 != p2) {
            // If no intersection then both will become null at the same time
            // since they are travelling equal distances of (head1 + head2)
            p1 = (p1 == null) ? head2 : p1.next;
            p2 = (p2 == null) ? head1 : p2.next;
        }
        return p1;
    }

    private static void attachTail(ListNode head, ListNode tail) {
        if (head == null) return;

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = tail;
    }
}
