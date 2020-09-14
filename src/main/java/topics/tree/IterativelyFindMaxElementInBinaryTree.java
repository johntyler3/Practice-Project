package topics.tree;

import java.util.Stack;

/*
Write a method to find the maximum element in a binary tree iteratively.
 */

//fireCode
public class IterativelyFindMaxElementInBinaryTree {

    public int findMaxItr(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int max = Integer.MIN_VALUE;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp != null) {
                if (temp.data > max) {
                    max = temp.data;
                }
                stack.push(temp.left);
                stack.push(temp.right);
            }
        }
        return max;
    }

}
