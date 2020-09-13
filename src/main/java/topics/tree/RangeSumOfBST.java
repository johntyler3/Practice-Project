package topics.tree;

import java.util.LinkedList;
import java.util.Queue;

public class RangeSumOfBST {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        if (root != null) {
            Queue<TreeNode> nodeQueue = new LinkedList();
            nodeQueue.add(root);

            while (!nodeQueue.isEmpty()) {
                TreeNode n = nodeQueue.remove();
                if (n.val >= L && n.val <= R) {
                    sum += n.val;
                }

                if (n.left != null) {
                    nodeQueue.add(n.left);
                }

                if (n.right != null) {
                    nodeQueue.add(n.right);
                }
            }

        }
        return sum;
    }

}
