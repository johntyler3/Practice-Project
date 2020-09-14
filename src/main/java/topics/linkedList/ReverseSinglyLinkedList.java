package topics.linkedList;

/*
Given the head pointer of a singly linked list, implement a method to reverse the list and return the new head.
 */

//fireCode
public class ReverseSinglyLinkedList {

    public ListNode reverseList(ListNode head) {

        if (head ==null) {
            return null;
        }

        ListNode previous = null;

        while (head != null) {
            ListNode front = head.next;
            head.next = previous;
            previous = head;
            head = front;
        }

        return previous;
    }

}
