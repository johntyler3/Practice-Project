package leetCode;

import java.util.Stack;

public class KthSmallestElementInBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n1 = new TreeNode(1);

        n5.left = n3;
        n5.right = n6;

        n3.left = n2;
        n3.right = n4;

        n2.left = n1;

        int result = kthSmallest(n5, 6);
    }

    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;

        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                k = k - 1;
                if(k == 0) {
                    return node.val;
                }
                p = node.right;
            }
        }

        return Integer.MIN_VALUE;
    }

}
