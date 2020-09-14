package topics.backtracking;

import topics.tree.TreeNode;

//fireCode
public class DistanceOfNodeFromRoot {

    public int pathLengthFromRoot(TreeNode root, int n) {

        if (root == null) {
            return 0;
        }

        int length = 0;

        if (root.data == n ||
                (length = pathLengthFromRoot(root.left, n)) > 0 ||
                (length = pathLengthFromRoot(root.right, n)) > 0) {
            return length + 1;
        }

        return 0;

    }

}
