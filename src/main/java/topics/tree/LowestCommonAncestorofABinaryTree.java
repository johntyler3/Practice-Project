package topics.tree;

import java.util.*;

public class LowestCommonAncestorofABinaryTree {

    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);

        n3.left = n5;
        n3.right = n1;

        n1.left = new TreeNode(0);
        n1.right = new TreeNode(8);

        n5.left = new TreeNode(6);
        n5.right = n2;

        n2.left = new TreeNode(7);
        n2.right = new TreeNode(4);

        TreeNode lca = lowestCommonAncestor(n3, n5, n1);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        //Stack for tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();

        //HashMap for parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        //Iterate until we find both the nodes p and q
        while(!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();

            //While traversing the tree, keep saving parent pointers
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet();

        //Get all the ancestors for node p using parent map
        while(p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        //Get  all the ancestors for node q until one is found in ancestors of p
        while(!ancestors.contains(q)) {
            q = parent.get(q);
        }

        return q;
    }

}
