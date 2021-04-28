package topics.linkedList;

/*
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

Example 1:
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: l1 = [], l2 = []
Output: []

Example 3:
Input: l1 = [], l2 = [0]
Output: [0]
 */

//leetCode #21
public class MergeTwoSortedLists {

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
