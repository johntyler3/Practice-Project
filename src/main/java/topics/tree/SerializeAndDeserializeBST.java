package topics.tree;

/*
Serialization is converting a data structure or object into a sequence of bits so
that it can be stored in a file or memory buffer, or transmitted across a network
connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree.
There is no restriction on how your serialization/deserialization algorithm should work.

You need to ensure that a binary search tree can be serialized to a string, and this
string can be deserialized to the original tree structure.
The encoded string should be as compact as possible.

Example 1:
Input: root = [2,1,3]
Output: [2,1,3]

Example 2:
Input: root = []
Output: []
 */

//leetCode #449
public class SerializeAndDeserializeBST {

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private static void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val + ",");
        dfs(root.left, sb);
        dfs(root.right, sb);
        return;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        TreeNode root = null;
        for (String s : arr) {
            if (s.length() > 0) {
                root = buildBST(root, Integer.parseInt(s));
            }
        }
        return root;
    }

    public static TreeNode buildBST(TreeNode root, int v) {
        if (root == null) return new TreeNode(v);
        if (v < root.val) {
            root.left = buildBST(root.left, v);
        } else {
            root.right = buildBST(root.right, v);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode testTree = new TreeNode(2);
        testTree.left = new TreeNode(1);
        testTree.right = new TreeNode(3);

        String serialized  = serialize(testTree);

        TreeNode deserialized  =  deserialize(serialized);

    }



}
