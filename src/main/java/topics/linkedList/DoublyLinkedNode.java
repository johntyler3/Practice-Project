package topics.linkedList;

public class DoublyLinkedNode {

    public DoublyLinkedNode next;
    public DoublyLinkedNode prev;
    public int data;

    public DoublyLinkedNode(int data) {
        this.data = data;
    }

    public DoublyLinkedNode(DoublyLinkedNode next, DoublyLinkedNode prev) {
        this.next = next;
        this.prev = prev;
    }

    public DoublyLinkedNode(DoublyLinkedNode next, DoublyLinkedNode prev, int data) {
        this.next = next;
        this.prev = prev;
        this.data = data;
    }

    public DoublyLinkedNode() {
    }
}
