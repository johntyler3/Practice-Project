package topics.math;

/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

Example 1:
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:
Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
 */

//leetCode #268
public class MissingNumber {

    /*
    Gauss' Rule :
	The sum of natural numbers from 0 to n is equal to (n * (n - 1) / 2)
	This algorithm is useful when determining a missing number from a sequence of numbers quickly
    It allows us to find a missing number without using extra space to find the number

     */

    public int missingNumber(int[] nums) {
        int runningTotal = 0;
        for (int i = 0; i < nums.length; i++) {
            runningTotal += nums[i];
        }

        int n = nums.length + 1;

        return (n * (n - 1) / 2) - runningTotal;
    }
}
