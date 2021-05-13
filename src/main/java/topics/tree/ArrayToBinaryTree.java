package topics.tree;

/*
Given an array of elements, our task is to construct a complete binary tree from this array in level order fashion.
That is, elements from left in the array will be filled in the tree level wise starting from level 0.

Examples:
Input  :  arr[] = {1, 2, 3, 4, 5, 6}
Output : Root of the following tree
                  1
                 / \
                2   3
               / \ /
              4  5 6


Input: arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6}
Output: Root of the following tree
                   1
                  / \
                 2   3
                / \ / \
               4  5 6  6
              / \ /
             6  6 6
 */

//Geeks for Geeks
public class ArrayToBinaryTree {

    public TreeNode arrayToTree(int[] nodes)  {

        TreeNode result = arrayToTreeHelp(nodes, 0);

        return result;

    }

    private TreeNode arrayToTreeHelp(int[] nodes, int index) {
        if (index >= nodes.length) {
            return null;
        }

        TreeNode root = new TreeNode(nodes[index]);
        root.left = arrayToTreeHelp(nodes, (index * 2) + 1);
        root.right = arrayToTreeHelp(nodes, (index * 2) + 2);
        return root;
    }

}
