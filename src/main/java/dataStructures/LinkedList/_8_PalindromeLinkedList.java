package dataStructures.LinkedList;

import java.util.Arrays;

/**
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 */
public class _8_PalindromeLinkedList {

    public static void main(String[] args) {
        IsPalindromeSolution solution = new IsPalindromeSolution();
        int[] nums = {1, 2, 2, 1};
        ListNode numsHead = ListNodeUtils.createLinkedListWithCycle(nums, -1);
        int[] nums2 = {1, 2, 3, 2, 1};
        ListNode nums2Head = ListNodeUtils.createLinkedListWithCycle(nums2, -1);
        int[] nums3 = {1};
        ListNode nums3Head = ListNodeUtils.createLinkedListWithCycle(nums3, -1);
        int[] nums4 = {1, 2, 3, 4, 5};
        ListNode nums4Head = ListNodeUtils.createLinkedListWithCycle(nums4, -1);
        int[] nums5 = {1, 2};
        ListNode nums5Head = ListNodeUtils.createLinkedListWithCycle(nums5, -1);

        System.out.printf("%s is palindrome ? : %b", Arrays.toString(nums), solution.isPalindrome(numsHead));
        System.out.printf("\n%s is palindrome ? : %b", Arrays.toString(nums2), solution.isPalindrome(nums2Head));
        System.out.printf("\n%s is palindrome ? : %b", Arrays.toString(nums3), solution.isPalindrome(nums3Head));
        System.out.printf("\n%s is palindrome ? : %b", Arrays.toString(nums4), solution.isPalindrome(nums4Head));
        System.out.printf("\n%s is palindrome ? : %b", Arrays.toString(nums5), solution.isPalindrome(nums5Head));
    }
}

class IsPalindromeSolution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverse(firstHalfEnd.next);

        ListNode front = head;
        ListNode back = secondHalfStart;
        boolean isPalindrome = true;

        while (isPalindrome && back != null) {
            if (front.val != back.val) {
                isPalindrome = false;
            }

            front = front.next;
            back = back.next;
        }

        firstHalfEnd.next = reverse(secondHalfStart);
        return isPalindrome;
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

