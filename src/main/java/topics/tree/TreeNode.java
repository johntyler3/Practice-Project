package topics.tree;

// Definition for a binary tree node.
public class TreeNode {
    public int data;
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.data = val;
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.data = val;
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
