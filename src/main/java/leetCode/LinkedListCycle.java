package leetCode;

public class LinkedListCycle {
    public class ListNode{
        int val;
        ListNode next;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode first = head.next;
        ListNode second = head;

        while (first != second) {
            if (first == null || first.next == null) {
                return false;
            }
            second = second.next;
            first = first.next.next;

        }

        return true;
    }
}
