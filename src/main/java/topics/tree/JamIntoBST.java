package topics.tree;

//fireCode
public class JamIntoBST {

    public TreeNode insert(TreeNode root, int data) {

        if (root == null) {
            return new TreeNode(data);
        }

        if (root.data > data) {
            if (root.left != null) {
                insert(root.left, data);
            } else {
                TreeNode newNode = new TreeNode(data);
                root.left = newNode;
            }
        } else if (root.data < data) {
            if (root.right != null) {
                insert(root.right, data);
            } else {
                TreeNode newNode = new TreeNode(data);
                root.right = newNode;
            }
        }

        return root;

    }

}
