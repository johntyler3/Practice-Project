package topics.tree;

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
