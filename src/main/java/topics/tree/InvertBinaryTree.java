package topics.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
Given the root of a binary tree, invert the tree, and return its root.

Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
 */

//leetCode  #226
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            if (node != null)  {
                TreeNode left = node.left;
                TreeNode right = node.right;

                node.left = right;
                node.right = left;

                queue.add(left);
                queue.add(right);
            }
        }

        return root;
    }

}
