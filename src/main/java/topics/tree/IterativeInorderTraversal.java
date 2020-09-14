package topics.tree;

import java.util.ArrayList;
import java.util.Stack;

/*
Given a binary tree, write a method to perform the inorder traversal iteratively.
Append the data of each node visited to an ArrayList. Return an empty Arraylist in the case of an empty tree.
 */

//fireCode
public class IterativeInorderTraversal {

    public ArrayList<Integer> inorderItr(TreeNode root) {

        ArrayList<Integer> myList = new ArrayList<>();

        if (root == null) {
            return myList;
        }

        Stack<TreeNode> nodeStack = new Stack<>();

        while (true) {
            while (root != null) {
                nodeStack.push(root);
                root = root.left;
            }


            if (nodeStack.isEmpty()) {
                break;
            }

            root = nodeStack.pop();
            myList.add(root.data);
            root = root.right;
        }

        return myList;

    }

}
