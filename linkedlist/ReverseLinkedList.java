package linkedlist;

import java.util.ArrayList;

import utils.ListNode;

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
