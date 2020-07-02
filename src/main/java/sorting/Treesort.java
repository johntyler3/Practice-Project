package sorting;

import java.util.Arrays;
import java.util.Stack;

public class Treesort {

    //Node class to create elements of BST
    private static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int val) {
            this.value = val;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 7, 8, 2, 9, 1, 3, 5, 10, 6};
        treeSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void treeSort(int[] array) {
        //create the BST
        Node root = new Node(array[0]);
        for (int i = 1; i < array.length; i++) {
            insertIntoBST(root, array[i]);
        }

        //perform in-order traversal of BST to get sorted input
        inOrderTraversal(root, array);
    }

    private static Node insertIntoBST(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.value) {
            root.left = insertIntoBST(root.left, val);
        } else if (val > root.value) {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    private static void inOrderTraversal(Node root, int[] array) {
        int index = 0;
        Stack<Node> nodeStack = new Stack<>();
        while (!nodeStack.isEmpty() || root != null) {
            while (root != null) {
                nodeStack.push(root);
                root = root.left;
            }

            root = nodeStack.pop();
            array[index] = root.value;
            index++;
            root = root.right;
        }
    }
}
