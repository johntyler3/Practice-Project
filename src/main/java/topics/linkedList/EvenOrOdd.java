package topics.linkedList;

/*
Given a singly-linked list, check whether its length is even or odd in a single pass.
An Empty list has 0 nodes which makes the number of nodes in it even.
 */

//fireCode
public class EvenOrOdd {

    public Boolean isListEven(ListNode head) {

        if (head == null) {
            return true;
        }

        int count = 1;
        while (head.next != null) {
            count++;
            head = head.next;
        }

        return (count % 2 == 0);
    }

}
