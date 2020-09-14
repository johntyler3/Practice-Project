package topics.tree;

/*
Given two binary trees, determine if they are identical.
If they are, return true otherwise return false.
 */

//fireCode
public class AreTheseBinaryTreesIdentical {

    public boolean isIdentical(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        else if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }

        return (root1.data == root2.data && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right));
    }

}
