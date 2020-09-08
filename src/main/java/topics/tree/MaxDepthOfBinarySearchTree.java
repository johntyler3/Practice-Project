package topics.tree;

//leetCode #104
public class MaxDepthOfBinarySearchTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = 1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);

        return Math.max(left, right);
    }
}
