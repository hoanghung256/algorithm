package twopointer;

import utils.ListNode;

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
