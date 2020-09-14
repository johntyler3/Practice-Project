package topics.tree;

import java.util.ArrayDeque;
import java.util.Queue;

//fireCode
public class IterativeBSTValidation {

    public static boolean validateBSTItr(TreeNode root) {
        if (root == null) {
            return false;
        }

        Queue<BSTNode> queue = new ArrayDeque<BSTNode>();
        BSTNode bstRoot = new BSTNode(
                root.data,
                Integer.MAX_VALUE,
                Integer.MIN_VALUE,
                root.left,
                root.right);
        queue.add(bstRoot);

        while (!queue.isEmpty()) {
            BSTNode bstNode = queue.remove();

            if (bstNode.left != null) {
                if (bstNode.left.data > bstNode.data || bstNode.left.data < bstNode.MIN_VAL) {
                    return false;
                }

                BSTNode left = new BSTNode(bstNode.left.data, bstNode.data, bstNode.left.data,  bstNode.left.left,  bstNode.left.right);
                queue.add(left);
            }

            if (bstNode.right != null) {
                if (bstNode.right.data < bstNode.data || bstNode.right.data > bstNode.MAX_VAL) {
                    return false;
                }


                BSTNode right = new BSTNode(bstNode.right.data, bstNode.right.data, bstNode.data,  bstNode.right.left,  bstNode.right.right);
                queue.add(right);
            }

        }

        return true;
    }


    public static class BSTNode {

        int MAX_VAL;
        int MIN_VAL;

        TreeNode left;
        TreeNode right;
        int data;


        public BSTNode(int newNodeData, int newMAX_VAL, int newMIN_VAL, TreeNode newLeftNode, TreeNode newRightNode) {
            this.MAX_VAL = newMAX_VAL;
            this.MIN_VAL = newMIN_VAL;
            this.left = newLeftNode;
            this.right = newRightNode;
            this.data = newNodeData;
        }

    }

}
