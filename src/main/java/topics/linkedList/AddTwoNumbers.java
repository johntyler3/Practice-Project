package topics.linkedList;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]
 */

//leetCode #2
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node = new ListNode(0);
        ListNode trav = node;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int l1Val = (l1 == null) ? 0 : l1.val;
            int l2Val = (l2 == null) ? 0 : l2.val;

            int sum = l1Val + l2Val + carry;
            System.out.println("sum = " + sum);
            carry = sum / 10;
            int lastDigit = sum % 10;
            System.out.println("lastDig = " + lastDigit);

            ListNode newNode = new ListNode(lastDigit);
            trav.next = newNode;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            trav = trav.next;
        }

        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            trav.next = newNode;
            trav = trav.next;
        }

        return node.next;
    }

}
