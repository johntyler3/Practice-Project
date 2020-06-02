package leetCode;

public class DeleteNodeInALinkedList {
    public class ListNode{
        int val;
        ReverseLinkedList.ListNode next;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
