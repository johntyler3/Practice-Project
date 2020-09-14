package topics.backtracking;

import topics.tree.TreeNode;

//fireCode
public class ValidateBST {

    public static boolean validateBST(TreeNode root) {
        return validateBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static boolean validateBST(TreeNode root, int max, int min) {
        if (root == null) {
            return true;
        }

        if (root.data > max || root.data < min) {
            return false;
        }

        return validateBST(root.right, max, root.data) && validateBST(root.left, root.data, min);
    }

}
