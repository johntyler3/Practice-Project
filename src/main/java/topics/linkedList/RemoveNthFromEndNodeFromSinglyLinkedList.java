package topics.linkedList;

/*
Given a singly-linked list, remove its Nth from the end node.
 */

//fireCode
public class RemoveNthFromEndNodeFromSinglyLinkedList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        ListNode returnNode = head;
        ListNode trav = head;
        int count = 1;

        while (trav.next != null) {
            trav = trav.next;
            count++;
        }

        if (count == n) {
            return head.next;
        }  else if (count < n) {
            return head;
        }

        while (count - 1 != n) {
            if (head.next.next != null) {
                head = head.next;
            }
            count--;
        }

        head.next = head.next.next;


        return returnNode;
    }
}
