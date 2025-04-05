package dataStructures.LinkedList;

public class _5_RemoveDuplicatesFromSortedLinkedList {

    public static void main(String... args) {
        int[] nums = {1, 1, 2, 3, 4, 4, 4, 5, 5, 6, 7, 8, 8, 8, 9, 10, 11, 12, 12};
        ListNode current = ListNodeUtils.createLinkedListWithCycle(nums, -1);
        ListNode prev = null;

        while (current != null) {
            if (prev != null && prev.val == current.val) {
                prev.next = current.next;
            } else {
                prev = current;
                System.out.printf("%d -> ", prev.val);
            }
            current = current.next;
        }

        System.out.println("null");
    }
}
