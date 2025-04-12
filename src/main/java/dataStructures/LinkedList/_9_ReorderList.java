package dataStructures.LinkedList;

import java.util.Arrays;

public class _9_ReorderList {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        ListNode nums1Head = ListNodeUtils.createLinkedListWithCycle(nums1, -1);
        int[] nums2 = {1, 2, 3, 4};
        ListNode nums2Head = ListNodeUtils.createLinkedListWithCycle(nums2, -1);
        int[] nums3 = {1, 2};
        ListNode nums3Head = ListNodeUtils.createLinkedListWithCycle(nums3, -1);
        int[] nums4 = {1};
        ListNode nums4Head = ListNodeUtils.createLinkedListWithCycle(nums4, -1);

        ReorderLinkedListSolution solution = new ReorderLinkedListSolution();

        System.out.printf("\n%s : ", Arrays.toString(nums1));
        ListNodeUtils.printLinkedList(solution.reorderList(nums1Head), 10);

        System.out.printf("\n%s : ", Arrays.toString(nums2));
        ListNodeUtils.printLinkedList(solution.reorderList(nums2Head), 10);

        System.out.printf("\n%s : ", Arrays.toString(nums3));
        ListNodeUtils.printLinkedList(solution.reorderList(nums3Head), 10);

        System.out.printf("\n%s : ", Arrays.toString(nums4));
        ListNodeUtils.printLinkedList(solution.reorderList(nums4Head), 10);
    }
}

class ReorderLinkedListSolution {
    public ListNode reorderList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverse(firstHalfEnd.next);
        firstHalfEnd.next = null;

        ListNode back = secondHalfStart;
        ListNode current = head;

        while (back != null) {
            ListNode nextNodeFromFront = current.next;
            ListNode nextNodeFromBack = back.next;
            current.next = back;
            back.next = nextNodeFromFront;
            back = nextNodeFromBack;
            current = nextNodeFromFront;
        }

        return head;
    }

    private ListNode endOfFirstHalf(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;

        while (node != null) {
            ListNode nextNode = node.next;
            node.next = prev;
            prev = node;
            node = nextNode;
        }

        return prev;
    }
}