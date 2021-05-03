package topics.dynamicProgramming;


/*
Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).


Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 */

import java.util.Arrays;

//leetCode #303
public class RangeSumQueryImmutable {

    /*
    First attempt - simply iterate over nums, adding up values and returning them
    This ends up being slow on many calls because we are guaranteed that the numArray will not change
    We can use dynamic programming to speed up retrieval of previous ranges
     */

    public static class NumArray {
        int[] numArray;

        public NumArray(int[] nums) {
                numArray = nums;
            }

        public int sumRange(int left, int right) {
            int sumRange = 0;

            if (numArray != null) {

                for (int i = left; i <= right; i++) {
                    sumRange += numArray[i];
                }
            }

            return sumRange;
        }
    }

    /*
    Second Attempt - use memoization to save sums
     */

    public static class NumArray2 {
        int[] numArray;

        public NumArray2(int[] nums) {
            numArray = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                numArray[i + 1] = nums[i]  + numArray[i];
            }
        }

        public int sumRange(int left, int right) {
            return numArray[right + 1] - numArray[left];
        }
    }


    public static void main(String[] args) {
        NumArray2 numArray2 = new NumArray2(new int[]{-2, 0, 3, -5, 2, -1});

        int sum1 = numArray2.sumRange(0, 5);
    }
}
