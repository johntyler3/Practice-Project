package topics.sort;

import topics.linkedList.ListNode;


//leetCode #148
public class SortList {

    /*
    -   Given the head of a linked list, return the list after sorting it in ascending order.
    -   Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
     */

    //this solution uses "top down" merge sort and runs in O(nlog(n)) time and takes O(log(n)) space
    //we make log(n) recursive calls during merge sort and so the entire function takes O(log(n)) space due to call stack
    public ListNode mergeSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = mergeSortList(head);
        ListNode right = mergeSortList(mid);
        return merge(left, right);
    }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val  < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }

        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

}
