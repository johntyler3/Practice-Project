package topics.linkedList;

import java.util.HashSet;

/*
Given a singly-linked list, remove duplicates in the list and return head of the list.
Target a worst case space complexity of O(n).
 */

//fireCode
public class RemoveDuplicateNodes {

    public ListNode removeDuplicates(ListNode head) {

        if (head != null) {
            HashSet<Integer> nodeSet = new HashSet();
            ListNode slow = null;
            ListNode trav = head;

            while (trav != null) {
                if (nodeSet.contains(trav.data)) {
                    slow.next = trav.next;
                } else {
                    nodeSet.add(trav.data);
                }
                slow = trav;
                trav = trav.next;
            }
        }

        return head;
    }

}
