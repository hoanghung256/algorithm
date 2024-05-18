package twopointer;

import utils.ListNode;

/**
 * Given the head of a singly linked list, return true if it is a
 * palindrome
 * or false otherwise.
 * 
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 * 
 * Example 2:
 * Input: head = [1,2]
 * Output: false
 * 
 * Constraints:
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 */

public class PalindromeLinkedList {
    // Compare to half of list approach 
    public static boolean isPalindrome(ListNode head) {
        ListNode right = head;
        ListNode mid = head;
        int listLength = 1;

        while (right.next != null) {
            right = right.next;
            listLength++;
        }

        int[] halfList = new int[listLength / 2];

        for (int i = 0; i < listLength / 2; i++) {
            halfList[i] = mid.val;
            mid = mid.next;
        }

        if (listLength % 2 == 1) {
            mid = mid.next;
        }

        for (int i = listLength / 2 - 1; i >= 0; i--) {
            if (halfList[i] != mid.val) {
                return false;
            }

            mid = mid.next;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Testcase 1 (expected true): " + isPalindrome(ListNode.createNewListNode(1, 2, 2, 1)));
        System.out.println("Testcase 2 (expected false): " + isPalindrome(ListNode.createNewListNode(1, 2)));
        System.out.println("Testcase 3 (expected true): " + isPalindrome(ListNode.createNewListNode(1, 2, 3, 3, 2, 1)));
        System.out.println("Testcase 4 (expected true): " + isPalindrome(ListNode.createNewListNode(1)));
        System.out.println("Testcase 5 (expected true): " + isPalindrome(ListNode.createNewListNode(1, 1)));
        System.out.println("Testcase 6 (expected true): " + isPalindrome(ListNode.createNewListNode(1, 2, 0, 2, 1)));
    }
}
