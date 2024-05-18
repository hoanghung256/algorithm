package linkedlist;

import java.util.ArrayList;

import utils.ListNode;

/**
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
 * 
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * 
 * Example 2:
 * Input: head = [1,2]
 * Output: [2,1]
 * 
 * Example 3:
 * Input: head = []
 * Output: []
 * 
 * Constraints:
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 * 
 * Follow up: A linked list can be reversed either iteratively or recursively.
 * Could you implement both?
 */

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        current = head;
        for (int i = list.size() - 1; i >= 0; i--) {
            current.val = list.get(i);
            current = current.next;
        }

        return head;
    }
}
