package dataStructures.LinkedList;

import java.util.Optional;

public class _3_DetectCycleInLinkedList {

    public static void main(String... args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int cycleIndex = 3;
        ListNode node = createCycleLL(nums, cycleIndex);
        if (node == null) {
            System.out.println("No data!");
            return;
        }

        ListNode slow = node;
        ListNode fast = node;
        boolean isCyclePresent = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCyclePresent = true;
                break;
            }
        }

        if (isCyclePresent) {
            slow = node;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            System.out.printf("Cycle starts at node with value: %d%n", slow.val);
        } else {
            System.out.println("No cycle detected!");
        }
    }

    private static ListNode createCycleLL(int[] nums, int cycleIndex) {
        if (nums == null || nums.length == 0) return null;

        ListNode head = new ListNode(-1);
        ListNode current = head;
        ListNode cycleNode = null;

        for (int i = 0; i < nums.length; i++) {
            ListNode nextNode = new ListNode(nums[i]);
            current.next = nextNode;
            current = nextNode;

            if (i == cycleIndex) {
                cycleNode = current;
            }
        }

        if (cycleNode != null) {
            current.next = cycleNode;
        }

        return head.next;
    }
}
