package topics.linkedList;

/*
Given a doubly-linked list, write a method to delete the node at a given position
(starting from 1 as the head position) and return the modified list's head.
Do nothing if the input position is out of range.
 */

//fireCode
public class DeleteNodeAtPositionDoublyLinkedList {

    public DoublyLinkedNode deleteAtPos(DoublyLinkedNode head, int pos) {

        if (head == null) {
            return null;
        } else if (pos == 1) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return head;
        }

        DoublyLinkedNode fast = head.next;
        DoublyLinkedNode slow = head;

        int nodeCount = 2;


        while (fast != null) {
            if (nodeCount == pos) {
                slow.next = fast.next;
                if (fast.next != null) {
                    fast = fast.next;
                    fast.prev = slow;
                }
                return head;
            } else {
                fast = fast.next;
                slow = slow.next;
                nodeCount++;
            }
        }
        return head;
    }

}
