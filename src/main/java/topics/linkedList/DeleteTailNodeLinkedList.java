package topics.linkedList;

/*
Given a singly-linked list, write a method to delete its last node and return the head.
 */

//fireCode
public class DeleteTailNodeLinkedList {

    public ListNode deleteAtTail(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode traverse = head;
        while (traverse.next != null && (traverse.next).next != null) {
            traverse = traverse.next;
        }

        traverse.next = null;
        return head;
    }

}
