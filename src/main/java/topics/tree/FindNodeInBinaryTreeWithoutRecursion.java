package topics.tree;

import java.util.LinkedList;
import java.util.Queue;

//fireCode
public class FindNodeInBinaryTreeWithoutRecursion {

    public TreeNode findNode(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> treeNodeQ = new LinkedList();
        treeNodeQ.add(root);

        while (treeNodeQ.size() != 0) {
            TreeNode check = treeNodeQ.poll();
            if (check.data == val) {
                return check;
            }

            if (check.left != null) {
                treeNodeQ.add(check.left);
            }

            if (check.right != null) {
                treeNodeQ.add(check.right);
            }
        }


        return null;
    }

}
