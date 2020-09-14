package topics.linkedList;

/*
Given a singly-linked list, write a method to delete the first node of the list and return the new head.
 */

//fireCode
public class DeleteListHeadNode {

    public ListNode deleteAtHead(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newNode = head.next;
        head = null;
        return newNode;
    }

}
