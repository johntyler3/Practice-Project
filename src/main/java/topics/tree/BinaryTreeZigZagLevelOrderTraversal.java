package topics.tree;

import java.util.*;

//leetCode #103
public class BinaryTreeZigZagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.right = n5;

        zigzagLevelOrder(n1);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList();
        List<Integer> rootList = new ArrayList();
        if (root != null) {
            rootList.add(root.val);
            ret.add(rootList);

            Queue<TreeNode> queue = new LinkedList();
            Stack<TreeNode> levelQueue = new Stack();
            queue.add(root);
            boolean rightNodeFirst = false;

            while (!queue.isEmpty()) {
                TreeNode n = queue.remove();

                if (rightNodeFirst && n.right != null) {
                    levelQueue.push(n.right);
                }
                if (n.left != null) {
                    levelQueue.push(n.left);
                }
                if (!rightNodeFirst && n.right != null) {
                    levelQueue.push(n.right);
                }

                //there are more elements in the next level
                if (queue.isEmpty() && !levelQueue.isEmpty()) {
                    List<Integer> levelList = new ArrayList();
                    while (!levelQueue.isEmpty()) {
                        TreeNode node = levelQueue.pop();
                        levelList.add(node.val);
                        queue.add(node);
                    }
                    ret.add(levelList);

                    //flip zig zag
                    rightNodeFirst = !rightNodeFirst;
                }
            }
        }

        return ret;
    }

}
