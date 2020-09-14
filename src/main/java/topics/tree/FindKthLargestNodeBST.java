package topics.tree;

import java.util.ArrayList;

//fireCode
public class FindKthLargestNodeBST {

    public TreeNode findKthLargest(TreeNode root, int k) {

        ArrayList<TreeNode> nodeList = getNodeList(root, new ArrayList());
        if (nodeList != null) {
            int returnIndex = nodeList.size() - k;
            if (returnIndex >= 0 && returnIndex < nodeList.size()) {
                return nodeList.get(returnIndex);
            }
        }
        return null;
    }



    private ArrayList<TreeNode> getNodeList(TreeNode node, ArrayList<TreeNode> myList) {
        if (node == null) {
            return myList;
        }

        if (node.left != null) {
            getNodeList(node.left, myList);
        }

        myList.add(node);

        if (node.right != null) {
            getNodeList(node.right, myList);
        }

        return myList;
    }

}
