package topics.backtracking;

public class LowestCommonAncestorOfABinaryTree {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode ans;

    public LowestCommonAncestorOfABinaryTree() {
        this.ans = null;
    }

    /*
    -   Start traversing the tree from the root node.
    -   If the current node itself is one of p or q, we would mark a variable mid as True and continue the search for the other node in the left and right branches.
    -   If either of the left or the right branch returns True, this means one of the two nodes was found below.
    -   If at any point in the traversal, any two of the three flags left, right or mid become True, this means we have found the lowest common ancestor for the nodes p and q.
    */

    public boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        if (currentNode == null) {
            return false;
        }

        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        //If any two of the flags are true, this is the LCA
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        //Return true if any of the three bool values is true
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.recurseTree(root, p, q);
        return this.ans;
    }

}
