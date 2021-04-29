package topics.linkedList;

/*
Given the head of a singly linked list, group all the nodes with odd indices together followed by the
nodes with even indices, and return the reordered list.
The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input.

Example 1:
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]

Example 2:
Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
 */

//leetCode #328
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode even = new ListNode(head.next.val);
        ListNode evenHead = even;

        ListNode odd = new ListNode(head.val);
        ListNode oddHead = odd;
        boolean oddNode = true;

        ListNode trav = head.next;
        while (trav.next != null) {
            trav = trav.next;
            if (oddNode) {
                odd.next = trav;
                odd = odd.next;
            } else {
                even.next = trav;
                even = even.next;
            }
            oddNode = !oddNode;
        }

        even.next = null;
        odd.next = evenHead;
        return oddHead;
    }

}
