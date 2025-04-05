package dataStructures.LinkedList;

public class _7_AddTwoNumbers {

    public static void main(String[] args) {

        AddTwoNumbersSolution solution = new AddTwoNumbersSolution();

        ListNode node1 = new ListNode(9);
        node1.next = new ListNode(9);
        node1.next.next = new ListNode(9);

        ListNode node2 = new ListNode(3);
        node2.next = new ListNode(2);

        /*
          Try:
          789 + 843 = 1632
          789 + 43 =  832
          999 + 32 = 1031
        */
        solution.addTwoNumbers(node1, node2);
    }
}

class AddTwoNumbersSolution {
    public void addTwoNumbers(ListNode node1, ListNode node2) {

        node1 = reverse(node1);
        node2 = reverse(node2);

        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        int carry = 0;

        while (node1 != null && node2 != null) {
            int sum = node1.val + node2.val + carry;
            result.next = new ListNode(sum % 10);
            result = result.next;
            carry = sum / 10;
            node1 = node1.next;
            node2 = node2.next;
        }


        while (node1 != null) {
            int sum = node1.val + carry;
            result.next = new ListNode(sum % 10);
            result = result.next;
            node1 = node1.next;
            carry = sum / 10;
        }

        while (node2 != null) {
            int sum = node2.val + carry;
            result.next = new ListNode(sum % 10);
            result = result.next;
            node2 = node2.next;
            carry = sum / 10;
        }

        if (carry != 0) {
            result.next = new ListNode(carry);
        }

        result = reverse(dummy.next);

        int sum = 0;
        while (result != null) {
            sum = sum * 10 + result.val;
            result = result.next;
        }

        System.out.printf("Sum = %d", sum);
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