package topics.tree;
import java.util.ArrayDeque;
import java.util.Queue;

/*
Write a function to find the total number of half nodes in a binary tree.
A half node is a node which has exactly one child node. If there are no half nodes, return 0.
 */

//fireCode
public class NumberOfHalfNodesInBST {

    public int numberOfHalfNodes(TreeNode root) {
        int count = 0;
        if (root == null) {
            return count;
        }

        Queue<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            if (node != null) {
                if ((node.left == null && node.right != null) || (node.left != null && node.right == null)) {
                    count++;
                }

                if (node.left != null) {
                    nodeQueue.add(node.left);
                }

                if (node.right != null) {
                    nodeQueue.add(node.right);
                }
            }
        }

        return count;

    }

}
