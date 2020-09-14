package topics.linkedList;

/*
Write a method to insert a node at the end of a singly-linked list. Return the head of the modified list.
 */

//fireCode
public class InsertNodeAtEndLinkedList {

    public ListNode insertAtTail(ListNode head, int data) {

        if (head == null) {
            return new ListNode(data);
        }

        ListNode trav = head;

        while (trav.next != null) {
            trav = trav.next;
        }

        trav.next = new ListNode(data);
        return head;
    }

}
