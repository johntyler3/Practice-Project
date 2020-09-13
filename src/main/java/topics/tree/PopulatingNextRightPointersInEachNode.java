package topics.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public static void main(String[] args) {
        Node n5 = new Node(5);
        Node n3 = new Node(3);
        Node n6 = new Node(6);
        Node n2 = new Node(2);
        Node n4 = new Node(4);
        Node n1 = new Node(1);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        Node n = connect(n1);
    }

    //Optimal Solution that runs in O(N) time and takes O(1) space
    public Node connectOptimal(Node root) {

        if(root == null) {
            return null;
        }

        Node pre = root;

        //Loop down the left side of the tree
        while(pre.left != null) {
            Node curr = pre;

            //Loop while the current node is not equal to null
            while(curr != null){

                //The current node's left child's next pointer will always point to the current node's right child
                curr.left.next = curr.right;

                //Only set the right node's next pointer if we are on the left side of the tree
                if(curr.next != null){

                    //The current node's right child's next pointer will always point to the current's next's left child
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            pre = pre.left;
        }
        return root;
    }

    //This is how I originally solved the problem, although it is not the most efficient
    public static Node connect(Node root) {

        if (root == null) {
            return root;
        }

        Queue<Node> nodeQueue = new LinkedList();
        Queue<Node> levelQueue = new LinkedList();

        nodeQueue.add(root);
        root.next = null;

        while (!nodeQueue.isEmpty()) {
            Node n = nodeQueue.remove();

            if (n.right != null) {
                levelQueue.add(n.right);
            }

            if (n.left != null) {
                levelQueue.add(n.left);
            }

            if (nodeQueue.isEmpty()) {
                Node next = null;
                while(!levelQueue.isEmpty()) {
                    Node levelNode = levelQueue.remove();
                    levelNode.next = next;
                    next = levelNode;
                    nodeQueue.add(levelNode);
                }

            }
        }

        return root;
    }

}
