package topics.tree;

import java.util.Stack;

/*
Given a binary tree, write a method to find and return the sum of all nodes of the tree iteratively.
 */

//fireCode
public class SumAllElementsInBinaryTreeIteratively {

    public int sumItr(TreeNode root) {

        int sum = 0;

        if (root != null) {
            Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
            treeNodeStack.push(root);
            while (!treeNodeStack.isEmpty()) {
                TreeNode temp = treeNodeStack.pop();
                if (temp != null) {
                    sum += temp.data;

                    treeNodeStack.push(temp.left);
                    treeNodeStack.push(temp.right);
                }
            }
        }
        return sum;
    }

}
