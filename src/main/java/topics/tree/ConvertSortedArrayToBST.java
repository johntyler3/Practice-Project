package topics.tree;

/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.


Example 1:
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 */

//leetCode #108
public class ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }

        return sortedArrayToBSTHelp(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBSTHelp(int[] nums, int beg, int end) {
        if (beg > end) {
            return null;
        }

        //find middle element (next root)
        int rootIndex = beg + (end - beg) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);

        //recurse set left and right elements
        root.left = sortedArrayToBSTHelp(nums, beg, rootIndex - 1);
        root.right = sortedArrayToBSTHelp(nums, rootIndex + 1, end);

        return root;
    }
}
