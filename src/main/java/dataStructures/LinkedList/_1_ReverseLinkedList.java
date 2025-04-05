package dataStructures.LinkedList;

public class _1_ReverseLinkedList {

    public static void main(String... args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);


        node = reverse(node);
        System.out.println(node == null ? "Result is null" : "Result is not null");

        while (node != null) {
            System.out.printf("%d -> ", node.val);
            node = node.next;
        }
    }

    public static ListNode reverse(ListNode node) {

        if (node == null) return null;

        ListNode prev = null;
        ListNode current = node;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}
