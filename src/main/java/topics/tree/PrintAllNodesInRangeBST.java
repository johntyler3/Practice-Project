package topics.tree;

import java.util.ArrayList;

public class PrintAllNodesInRangeBST {

    public ArrayList<Integer> rangeList = new ArrayList<Integer>();
    public void printRange(TreeNode root, int a, int b) {

        if (root == null) {
            return;
        }

        if (root.data > a)  {
            printRange(root.left, a, b);
        }

        if (root.data >= a && root.data <= b) {
            rangeList.add(root.data);
        }

        if (root.data < b) {
            printRange(root.right, a, b);
        }

    }

}
