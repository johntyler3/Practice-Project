package topics.tree;

/*
Given a binary tree, write a method to find and return its deepest node.
Return null for an empty tree.
 */

import java.util.LinkedList;
import java.util.Queue;

//fireCode
public class DeepestNode {

    public TreeNode findDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node.left != null) {
                nodeQueue.add(node.left);
            }

            if (node.right != null) {
                nodeQueue.add(node.right);
            }

            if (nodeQueue.isEmpty()) {
                return node;
            }
        }
        return root;
    }

}
