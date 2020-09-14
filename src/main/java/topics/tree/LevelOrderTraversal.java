package topics.tree;

import java.util.ArrayList;
import java.util.Stack;

/*
Given a binary tree, write a method to perform a levelorder traversal and return an ArrayList of
integers containing the data of the visited nodes in the correct order.
 */

//fireCode
public class LevelOrderTraversal {

    public ArrayList<Integer> levelorder(TreeNode root) {

        ArrayList<Integer> myList = new ArrayList<Integer>();

        if (root == null) {
            return myList;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> levelStack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node  = stack.pop();
            myList.add(node.data);

            if (node.left != null) {
                levelStack.push(node.left);
            }

            if (node.right != null) {
                levelStack.push(node.right);
            }

            if (stack.isEmpty()) {
                while (!levelStack.isEmpty()) {
                    stack.push(levelStack.pop());
                }
            }
        }

        return myList;
    }

}
