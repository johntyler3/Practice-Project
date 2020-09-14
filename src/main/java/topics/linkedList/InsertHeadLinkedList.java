package topics.linkedList;

/*
Write a method to insert a node at the front of a singly-linked list and return the head of the modified list.
 */

//fireCode
public class InsertHeadLinkedList {

    public ListNode insertAtHead(ListNode head, int data) {

        ListNode listNode = new ListNode(data);
        if (head == null) {
            return listNode;
        }

        listNode.next = head;
        return listNode;
    }

}
