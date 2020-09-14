package topics.tree;

//fireCode
public class HeightOfBinaryTree {

    public int findHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return 1 + Math.max(findHeight(root.right), findHeight(root.left));
    }

}
