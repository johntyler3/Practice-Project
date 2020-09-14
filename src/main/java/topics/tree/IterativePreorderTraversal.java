package topics.tree;

import java.util.ArrayList;

//fireCode
public class IterativePreorderTraversal {

    public ArrayList<Integer> preorderItr(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(root.data);
        if (root.left != null) {
            list.addAll(preorderItr(root.left));
        }

        if (root.right != null) {
            list.addAll(preorderItr(root.right));
        }



        return list;
    }

}
