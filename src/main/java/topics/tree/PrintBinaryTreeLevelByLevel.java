package topics.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//fireCode
public class PrintBinaryTreeLevelByLevel {

    public ArrayList<ArrayList<Integer>> printLevelByLevel(TreeNode root) {

        ArrayList<ArrayList<Integer>> myList = new ArrayList();
        if (root == null) {
            return myList;
        }

        ArrayList<Integer> levelList = new ArrayList();

        Queue<TreeNode> currentLevel = new LinkedList();
        Queue<TreeNode> nextLevel = new LinkedList();

        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            TreeNode thisNode = currentLevel.poll();
            levelList.add(thisNode.data);

            if (thisNode.left != null) {
                nextLevel.add(thisNode.left);
            }

            if (thisNode.right != null) {
                nextLevel.add(thisNode.right);
            }

            if (currentLevel.isEmpty()) {
                myList.add(levelList);
                levelList = new ArrayList();
                currentLevel = nextLevel;
                nextLevel = new LinkedList();
            }
        }
        return myList;
    }

}
