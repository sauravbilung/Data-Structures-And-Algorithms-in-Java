package dataStructures.LinkedList;

public class _6_RemoveNthNodeFromTheEnd {

    public static void main(String[] args) {

        RemoveNthNodeSolution solution = new RemoveNthNodeSolution();
        //int[] nums = {1, 2, 3, 4, 5};
        //int n = 2; // output : {1,2,3,5}

        int[] nums = {1, 2, 3, 4, 5};
        int n = 3; // output : {1,2,4,5}

        //int[] nums = {1};
        //int n = 1; // output = []

        //int[] nums = {1, 2};
        //int n = 1; // output = [1]

        //int[] nums = {1, 2};
        //int n = 2; // output = [2]

        //int[] nums = {1, 2, 3};
        //int n = 3; // output : [2,3]

        solution.print(nums, n);

    }
}

class RemoveNthNodeSolution {

    public void print(int[] nums, int n) {

        ListNode node = ListNodeUtils.createLinkedListWithCycle(nums, -1);

        if (node == null || n <= 0 || n > nums.length) {
            System.out.println("Invalid inputs !");
            return;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = node;
        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i <= n; i++) {
            if (fast == null) {
                System.out.println("Invalid inputs !");
                return;
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        node = dummy.next;

        while (node != null) {
            System.out.printf("%d -> ", node.val);
            node = node.next;
        }

        System.out.println("null");
    }
}
