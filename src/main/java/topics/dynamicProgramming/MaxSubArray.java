package topics.dynamicProgramming;

//leetCode #53
public class MaxSubArray {
    //this is the naive solution to this problem, runs in O(N^2)
    public int maxSubArrayNaive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int currentMax = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int currentCount = nums[i];
            currentMax = Math.max(currentCount, currentMax);
            for(int j = i + 1; j < nums.length; j++) {
                currentCount += nums[j];
                currentMax = Math.max(currentCount, currentMax);
            }
        }

        return currentMax;
    }

    //this is the optimal solution to this problem, runs in O(N) uses Kadane's Algorithm
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int currentMax = nums[0];
        int currentSum = currentMax;

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], nums[i] + currentSum);
            currentMax = Math.max(currentSum, currentMax);
        }

        return currentMax;
    }

}
