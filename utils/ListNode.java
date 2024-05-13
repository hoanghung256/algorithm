package utils;

/**
 * Definition for singly-linked list
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createNewListNode(int... values) {
        ListNode current = new ListNode(values[1]);
        ListNode head = new ListNode(values[0], current);

        for (int i = 2; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    public String toString() {
        ListNode current = this;
        StringBuilder result = new StringBuilder();

        result.append("[");
        while (current != null) {
            result.append(current.val);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");

        return result.toString();
    }
}
