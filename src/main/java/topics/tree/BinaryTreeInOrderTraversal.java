package topics.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]

Example 4:
Input: root = [1,2]
Output: [2,1]

Example 5:
Input: root = [1,null,2]
Output: [1,2]
 */

//leetCode #94
public class BinaryTreeInOrderTraversal {

    //Recursive solution
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> myList = new ArrayList();
        traverse(root, myList);
        return myList;
    }

    public void traverse(TreeNode node, List<Integer> myList) {
        if (node != null) {
            traverse(node.left, myList);
            myList.add(node.val);
            traverse(node.right, myList);
        }
    }

    //Iterative solution
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> myList = new ArrayList();
        if (root != null) {
            Stack<TreeNode> myStack = new Stack();
            TreeNode curr = root;

            while (curr != null || !myStack.isEmpty()) {
                while(curr != null) {
                    myStack.push(curr);
                    curr = curr.left;
                }
                curr = myStack.pop();
                myList.add(curr.val);
                curr = curr.right;
            }

        }
        return myList;
    }
}
