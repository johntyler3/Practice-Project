package topics.linkedList;

import java.util.ArrayList;

/*
Given a singly-linked list, implement the method that returns Nth node from the end of the list.
You are allowed to use extra memory for this implementation.
 */

//fireCode
public class FindNthNodeFromEndLinkedList {

    public ListNode findNthNodeFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        ArrayList<ListNode> myList = new ArrayList<ListNode>();

        while (head != null) {
            myList.add(head);
            head = head.next;
        }

        int returnIndex = (myList.size() - 1) - (n - 1);
        if (returnIndex >= 0 && returnIndex < myList.size()) {
            return myList.get(returnIndex);
        }


        return null;
    }

}
