package topics.tree;

/*
Given a binary tree consisting of nodes with positive integer values, write a method - maxSumPath that returns the
maximum sum of data values obtained by traversing nodes along a path between any 2 nodes of the tree. The path must
originate and terminate at 2 different nodes of the tree, and the maximum sum is obtained by summing all the data
values of the nodes traversed along this path.

Example:

     1
    / \
   2   3     => 18
  / \ / \
 4  5 6  7

Path: 5 -> 2 -> 1 -> 3 -> 7
Max Sum = 5+2+1+3+7 = 18

 */

//fireCode
public class MaximumSumPath {

    private static int recursiveHolder;

    public static int maxSumPath(TreeNode root) {

        maxSumPathHelper(root);
        int temp = recursiveHolder;
        recursiveHolder = 0;
        return temp;

    }

    public static int maxSumPathHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = maxSumPathHelper(root.left);
        int rightSum = maxSumPathHelper(root.right);

        int numCumVal = Math.max(root.data + leftSum, root.data + rightSum);
        recursiveHolder = Math.max(recursiveHolder, leftSum + root.data + rightSum);

        return numCumVal;
    }

}
