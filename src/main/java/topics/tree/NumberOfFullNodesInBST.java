package topics.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/*
Write a function to iteratively determine the total number of "full nodes" in a binary tree.
A full node contains left and right child nodes. If there are no full nodes, return 0.
 */

//fireCode
public class NumberOfFullNodesInBST {

    public int numberOfFullNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int fullNodeCount = 0;

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.left != null && node.right != null) {
                fullNodeCount++;
            } if (node.left != null) {
                queue.add(node.left);
            } if (node.right != null) {
                queue.add(node.right);
            }
        }

        return fullNodeCount;
    }

}
