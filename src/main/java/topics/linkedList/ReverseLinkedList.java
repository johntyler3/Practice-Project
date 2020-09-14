package topics.linkedList;

//leetCode #206
public class ReverseLinkedList {

    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode reverseListRecursive(ListNode head) {
        //returns a reversed linked list of length 0 or 1
        if (head == null || head.next == null) {
            return head;
        }
        //gets a reversed linked list for the rest of the list
        ListNode reversedHead = reverseListRecursive(head);

        //sets current head to the reversed list of nodes
        head.next.next = head;
        head.next = null;

        //return the entire reversed list
        return reversedHead;
    }
}
