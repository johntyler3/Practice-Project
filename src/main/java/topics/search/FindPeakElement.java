package topics.search;

public class FindPeakElement {

    //Optimal solution that uses the parameters of the problem to determine that we can use Binary Search
    //Because we can use Binary Search, a O(log(N)) solution is possible
    public int findPeakElementOptimal(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public int search(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }


    //Naive solution, follow up to problem wanted O(log(N)) time complexity
    public int findPeakElement(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {

            if (i == 0 && nums[i + 1] < nums[i]) {
                return i;
            } else if (i > 0 && i < nums.length - 1 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            } else if (i == nums.length - 1 && nums[i] > nums[i - 1]) {
                return i;
            }

        }
        return 0;
    }

}
