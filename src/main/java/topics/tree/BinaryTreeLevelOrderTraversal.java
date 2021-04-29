package topics.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, return the level order traversal of its nodes' values.
(i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []
 */

//leetCode #102
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> returnList = new ArrayList();

        if (root == null) {
            return returnList;
        }

        Queue<TreeNode> thisLevel = new LinkedList();
        Queue<TreeNode> nextLevel = new LinkedList();

        List<Integer> levelList = new ArrayList();

        thisLevel.add(root);
        while(!thisLevel.isEmpty()) {
            TreeNode node = thisLevel.remove();
            levelList.add(node.val);
            if (node.left != null) {
                nextLevel.add(node.left);
            }
            if (node.right != null) {
                nextLevel.add(node.right);
            }

            if (thisLevel.isEmpty()) {
                returnList.add(levelList);
                levelList = new ArrayList();
                while (!nextLevel.isEmpty()) {
                    thisLevel.add(nextLevel.remove());
                }
            }
        }

        return returnList;
    }

}
