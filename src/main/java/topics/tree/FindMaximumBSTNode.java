package topics.tree;

//fireCode
public class FindMaximumBSTNode {

    public TreeNode findMax(TreeNode root) {

        if (root == null) {
            return null;
        }

        while (root.right != null) {
            root = root.right;
        }

        return root;

    }

}
