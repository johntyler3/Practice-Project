package topics.tree;

/*
Given a Binary Search Tree, return the node with the minimum data.
 */

//fireCode
public class FindMinimumBSTNode {

    public TreeNode findMin(TreeNode root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
