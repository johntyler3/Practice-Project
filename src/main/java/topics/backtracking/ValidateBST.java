package topics.backtracking;

import topics.tree.TreeNode;

//fireCode and leetCode #98
public class ValidateBST {

    //solved on fireCode
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

    //solved on leetCode (they had a test case where the node values were equal to Integer.MAX_VALUE and Integer.MIN_VALUE)
    public boolean isValidBST(TreeNode root) {
        return validBST(root, null, null);
    }

    public boolean validBST(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }

        int val = root.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        return validBST(root.right, val, upper) && validBST(root.left, lower, val);
    }

}
