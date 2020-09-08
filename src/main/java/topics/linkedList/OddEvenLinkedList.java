package topics.linkedList;

//leetCode #328
public class OddEvenLinkedList {

    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val =  val;
        }
    }

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
