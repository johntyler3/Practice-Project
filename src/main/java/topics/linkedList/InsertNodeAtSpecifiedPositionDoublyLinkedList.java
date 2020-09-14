package topics.linkedList;

/*
In doubly linked list, implement a method to insert a node at specified position and return the list's head.
Do nothing if insertion position is outside the bounds of the list.
 */

//fireCode
public class InsertNodeAtSpecifiedPositionDoublyLinkedList {

    public DoublyLinkedNode insertAtPos(DoublyLinkedNode head, int data, int pos) {

        DoublyLinkedNode myNode = new DoublyLinkedNode(data);

        if (head == null) {
            if (pos == 1) {
                return myNode;
            }
            return null;
        } else if (pos == 1) {
            myNode.next = head;
            head.prev = myNode;
            return myNode;
        }

        DoublyLinkedNode trav = head;

        int count = 1;
        while (trav.next != null) {
            count++;
            if (pos == count) {
                myNode.next = trav.next;
                myNode.prev = trav;
                trav.next = myNode;
                return head;
            }
            trav = trav.next;
        }

        if ((count + 1) == pos) {
            trav.next = myNode;
            myNode.prev = trav;
        }

        return head;
    }

}
