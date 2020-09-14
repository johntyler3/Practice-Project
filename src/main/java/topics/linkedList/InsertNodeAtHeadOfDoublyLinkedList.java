package topics.linkedList;

/*
Given a doubly linked list, implement a method to insert a node at its head. Return the head of the list.
 */

//fireCode
public class InsertNodeAtHeadOfDoublyLinkedList {

    public DoublyLinkedNode insertAtHead(DoublyLinkedNode head, int data) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);

        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }

        return newNode;
    }

}
