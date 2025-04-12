package dataStructures.LinkedList;

public class _4_MergeTwoSortedLinkedList {
    public static void main(String... args) {
        int[] nums1 = {1, 3, 6, 7};
        int[] nums2 = {2, 5, 8, 10};

        ListNode node1 = ListNodeUtils.createLinkedListWithCycle(nums1, -1);
        ListNode node2 = ListNodeUtils.createLinkedListWithCycle(nums2, -1);

        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                result.next = node1;
                node1 = node1.next;
            } else {
                result.next = node2;
                node2 = node2.next;
            }
            result = result.next;
        }

        result.next = (node1 != null) ? node1 : node2;

        result = dummy.next;
        while (result != null) {
            System.out.printf("%d -> ", result.val);
            result = result.next;
        }
        System.out.println("null");
    }
}
