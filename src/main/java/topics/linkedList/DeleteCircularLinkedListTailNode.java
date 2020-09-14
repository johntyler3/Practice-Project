package topics.linkedList;

/*
Given a circular-linked list, write a function to delete its tail node and return the modified list's head.
*x = indicates head node

1->2->3->4->*1 ==> 1->2->3->*1
 */

//fireCode
public class DeleteCircularLinkedListTailNode {

    public ListNode deleteAtTail(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode trav = head;
        while (trav.next != head && trav.next.next != head) {
            trav = trav.next;
        }

        trav.next = head;
        return head;
    }

}
