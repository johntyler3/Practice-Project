package topics.linkedList;

/*
Given a singly-linked list, implement a method to check if the list has cycles.
The space complexity can be O(n). If there is a cycle, return true otherwise return false.
Empty lists should be considered non-cyclic.
 */

import java.util.HashSet;
import java.util.Set;

public class LoopingLists {

    public Boolean isCyclic(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        Set<ListNode> s = new HashSet<ListNode>();

        while (head.next != null) {
            if (!s.add(head)) {
                return true;
            }
            head = head.next;
        }

        return false;
    }

}
