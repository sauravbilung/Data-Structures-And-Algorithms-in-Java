package dataStructures.LinkedList;

import java.util.Arrays;

public class _2_MiddleOfLinkedList {

    public static void main(String... args) {
        int[] nums = {1, 2, 3, 4, 5, 6};

        ListNode slow = createList(nums);
        if (slow == null) {
            System.out.println("No data !");
            return;
        }

        ListNode fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        int[] result;

        if ((nums.length & 1) == 1) {
            result = new int[]{slow.val};
        } else {
            result = new int[]{slow.val, slow.next.val};
        }

        System.out.printf("Middle value : %s", Arrays.toString(result));
    }

    private static ListNode createList(int[] nums) {

        if (nums == null || nums.length == 0) return null;

        ListNode head = new ListNode(-1);
        ListNode current = head;

        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return head.next;
    }
}
