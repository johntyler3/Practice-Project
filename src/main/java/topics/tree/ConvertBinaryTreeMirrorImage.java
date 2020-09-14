package topics.tree;

/*
Write a function to convert a binary tree into its mirror image and return the root node of the mirrored tree.
 */

//fireCode
public class ConvertBinaryTreeMirrorImage {

    public TreeNode mirror(TreeNode root) {

        if (root == null) {
            return null;
        } else {
            //swap left and right
            TreeNode treeNode = root.left;
            root.left = root.right;
            root.right = treeNode;

            mirror(root.left);
            mirror(root.right);
        }

        return root;
    }

}
