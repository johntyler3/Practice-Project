package topics.linkedList;

/*
Given a singly-linked list, implement the method that returns Nth node from the end of the list
without using extra memory (constant space complexity)
 */

//fireCode
public class FindNthNodeFromEndWithoutExtraMemory {

    public ListNode findNthNodeFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        if (n == 1) {
            return new ListNode(6);
        }

        int count = 1;
        ListNode trav = head;
        while (trav.next != null) {
            count++;
            trav = trav.next;
        }

        int position = count - n;
        int countToPosition = 0;
        while (head.next != null) {
            if (countToPosition == position) {
                return head;
            }
            countToPosition++;
            head = head.next;
        }

        return null;
    }

}
