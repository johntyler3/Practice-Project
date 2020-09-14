package topics.linkedList;

/*
Given a circular linked list, implement a method to delete its head node. Return the list's new head node.

*x = indicates head node
1->2->3->4->*1 ==> 2->3->4->*2
 */

//fireCode
public class DeleteHeadNodeCircularLinkedList {

    public ListNode deleteAtHead(ListNode head) {

        if (head == null || (head.next.equals(head))) {
            return null;
        }


        ListNode nextNode = head.next;
        ListNode trav = head;

        while (trav.next != null && !((trav.next).equals(head))) {
            trav = trav.next;
        }

        trav.next = nextNode;
        return nextNode;

    }

}
