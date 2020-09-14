package topics.linkedList;

import java.util.Stack;

/*
Given a singly-linked list, write a method isListPalindrome to determine if the list is a palindrome.
A palindrome is a sequence that reads the same backward as forward.
 */

//fireCode
public class IsThisListAPalindrome {

    public Boolean isListPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }

        ListNode trav = head;

        int count = 0;

        Stack<ListNode> stack = new Stack<ListNode>();
        while (trav != null) {
            stack.push(trav);
            trav = trav.next;
            count++;
        }

        int newCount = 0;

        while (newCount < count / 2) {
            ListNode temp = stack.pop();
            if (temp.data != head.data) {
                return false;
            }

            head = head.next;
            newCount++;
        }

        return true;
    }

}
