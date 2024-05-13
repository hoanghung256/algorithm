package twopointer;

import utils.ListNode;

/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate
 * numbers, leaving only distinct numbers from the original list.
 * Return the linked list sorted as well.
 * 
 * Example 1:
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * 
 * Example 2:
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 * 
 * Constraints:
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */

public class RemoveDuplicatesFromSortedList2 {
    // Fast-slow pointers technic
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode current = dummy;

        while (current != null) {
            if (current.next != null && current.next.next != null && current.next.val == current.next.next.val) {
                ListNode temp = current.next.next;

                while (temp != null && temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                current.next = temp.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("Test case 1 (expected [1, 2, 5]): "
                + deleteDuplicates(ListNode.createNewListNode(1, 2, 3, 3, 4, 4, 5)).toString());
        System.out.println("Test case 1 (expected [2, 3]): "
                + deleteDuplicates(ListNode.createNewListNode(1, 1, 1, 2, 3)).toString());
    }
}
