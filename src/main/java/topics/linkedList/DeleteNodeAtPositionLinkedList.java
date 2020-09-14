package topics.linkedList;

/*
Given a singly-linked list, implement a method to delete the node at a given position
(starting from 1 as the head position) and return the head of the list.
Do nothing if the input position is out of range.
 */

//fireCode
public class DeleteNodeAtPositionLinkedList {

    public ListNode deleteAtMiddle(ListNode head, int position) {

        if (head == null) {
            return null;
        } else if (position == 1) {
            return head.next;
        }

        int nodePosition = 1;

        ListNode trav = head;
        while (trav.next != null) {
            if (nodePosition == (position - 1)) {
                trav.next = trav.next.next;
                break;
            }

            nodePosition++;
            trav = trav.next;

        }


        return head;
    }

}
