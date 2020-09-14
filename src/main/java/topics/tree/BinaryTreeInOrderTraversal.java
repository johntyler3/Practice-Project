package topics.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
