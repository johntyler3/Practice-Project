package topics.tree;

/*
Given a binary tree, write a recursive method to return the maximum element.
 */

//fireCode
public class FindMaxElementInBinaryTreeRecursively {

    public int findMax(TreeNode root) {

        int bigRight = root.data;
        int bigLeft = root.data;
        int bigBoi = root.data;

        if (root.right != null) {
            bigRight = findMax(root.right);
        }
        if (root.left != null) {
            bigLeft = findMax(root.left);
        }

        if (bigRight > bigLeft && bigRight > bigBoi) {
            bigBoi = bigRight;
        } else if (bigLeft > bigRight && bigLeft > bigBoi) {
            bigBoi = bigLeft;
        }


        return bigBoi;
    }

}
