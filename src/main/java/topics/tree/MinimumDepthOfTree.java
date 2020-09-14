package topics.tree;

import java.util.LinkedList;
import java.util.Queue;

//fireCode
public class MinimumDepthOfTree {

    public int minTreeDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int minLength = 1;
        Queue<TreeNode> thisLevelQueue = new LinkedList();
        Queue<TreeNode> nextLevelQueue = new LinkedList();
        thisLevelQueue.add(root);

        while (!thisLevelQueue.isEmpty()) {
            TreeNode thisNode = thisLevelQueue.poll();

            if (thisNode.left == null && thisNode.right == null) {
                return minLength;
            }

            if (thisNode.left != null) {
                nextLevelQueue.add(thisNode.left);
            }

            if (thisNode.right != null) {
                nextLevelQueue.add(thisNode.right);
            }

            if (thisLevelQueue.isEmpty()) {
                minLength++;
                while (!nextLevelQueue.isEmpty()) {
                    thisLevelQueue.add(nextLevelQueue.remove());
                }
            }
        }

        return minLength;
    }

}
