package topics.tree;

import java.util.Stack;

/*
Given a binary search tree and an integer k, implement a method to find and return the kth smallest node.
 */

//fireCode
public class FindKthSmallestNodeBST {

    public TreeNode findKthSmallest(TreeNode root, int k) {

        int nodeCount = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (stack.isEmpty()) {
                break;
            }

            root = stack.pop();
            // if (root != null) {
            nodeCount++;
            //}

            if (nodeCount == k) {
                return root;
            }

            root = root.right;

        }

        return null;

    }

}
