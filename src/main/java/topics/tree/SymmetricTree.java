package topics.tree;

import java.util.LinkedList;
import java.util.Queue;

//leetCode #101
public class SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return isRoot(root, root);
    }

    public boolean isRoot(TreeNode nodeA, TreeNode nodeB) {
        if (nodeA == null && nodeB == null) {
            return true;
        } else if (nodeA == null || nodeB == null || nodeA.val != nodeB.val) {
            return false;
        }
        return isRoot(nodeA.left, nodeB.right) && isRoot(nodeA.right, nodeB.left);
    }


    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> nodeQueue = new LinkedList();
        nodeQueue.add(root.left);
        nodeQueue.add(root.right);

        while (!nodeQueue.isEmpty()) {
            TreeNode myNode1 = nodeQueue.poll();
            TreeNode myNode2 = nodeQueue.poll();
            if (myNode1 == null && myNode2 == null) {
                continue;
            } else if (myNode1 == null || myNode2 == null || myNode1.val != myNode2.val) {
                return false;
            }
            nodeQueue.add(myNode1.left);
            nodeQueue.add(myNode2.right);

            nodeQueue.add(myNode1.right);
            nodeQueue.add(myNode2.left);
        }

        return true;
    }


}