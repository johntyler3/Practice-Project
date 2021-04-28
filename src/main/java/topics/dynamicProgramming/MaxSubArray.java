package topics.dynamicProgramming;

/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:
Input: nums = [1]
Output: 1

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
 */

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

    //this is the optimal solution to this problem, runs in O(N) uses dynamic programming Kadane's Algorithm
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
