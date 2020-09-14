package topics.linkedList;

//fireCode
public class FindMiddleNodeInSinglePass {

    public ListNode findMiddleNode(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode fastNode = head;
        ListNode slowNode = head;
        boolean moveSlow = false;

        while (fastNode.next != null) {
            fastNode = fastNode.next;
            if (moveSlow) {
                slowNode = slowNode.next;
            }
            moveSlow = !moveSlow;
        }
        return slowNode;
    }

}
