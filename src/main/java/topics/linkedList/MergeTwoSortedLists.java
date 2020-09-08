package topics.linkedList;

//leetCode #21
public class MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode dummyRoot = new ListNode();
        ListNode trav = dummyRoot;

        while(l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    trav.next = l1;
                    trav = l1;
                    l1 = l1.next;
                } else {
                    trav.next = l2;
                    trav = l2;
                    l2 = l2.next;
                }
            } else if (l1 == null) {
                trav.next = l2;
                trav = l2;
                l2 = l2.next;
            } else {
                trav.next = l1;
                trav = l1;
                l1 = l1.next;
            }
        }
        return dummyRoot.next;
    }
}
