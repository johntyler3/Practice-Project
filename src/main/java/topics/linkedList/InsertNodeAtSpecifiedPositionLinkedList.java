package topics.linkedList;

/*
Given a singly-linked list, implement a method to insert a node at a specific position and return the head of the list.
If the given position is greater than the list size, simply insert the node at the end.
 */

//fireCode
public class InsertNodeAtSpecifiedPositionLinkedList {

    public ListNode insertAtPosition(ListNode head, int data, int pos) {
        ListNode newHead = head;
        ListNode myNode = new ListNode(data);

        if (head == null) {
            return myNode;
        } else if (pos == 1) {
            myNode.next = head;
            return myNode;
        }

        int nodeCount = 1;
        ListNode firstNode = head;
        ListNode followNode = null;

        while (firstNode.next != null) {
            if (nodeCount == pos) {
                followNode.next = myNode;
                myNode.next = firstNode;
                return newHead;
            }
            followNode = firstNode;
            firstNode = firstNode.next;
            nodeCount++;
        }

        firstNode.next = myNode;

        return newHead;

    }

}
