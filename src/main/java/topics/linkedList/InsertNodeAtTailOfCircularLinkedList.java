package topics.linkedList;

/*
Given a circular linked list, write a method to insert a node at its tail. Return the list's head.
 */

//fireCode
public class InsertNodeAtTailOfCircularLinkedList {

    public ListNode insertAtTail(ListNode head, int data) {

        ListNode newListNode = new ListNode(data);

        if (head == null) {
            newListNode.next = newListNode;
            return newListNode;
        }

        ListNode trav = head;
        while(!((trav.next).equals(head))) {
            trav = trav.next;
        }

        trav.next = newListNode;
        newListNode.next = head;
        return head;
    }

}
