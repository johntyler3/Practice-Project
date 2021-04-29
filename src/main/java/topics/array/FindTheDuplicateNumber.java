package topics.array;

/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Example 3:
Input: nums = [1,1]
Output: 1

Example 4:
Input: nums = [1,1,2]
Output: 1
 */

//leetCode #287
public class FindTheDuplicateNumber {

    //This uses something called Floyd's algorithm to find a cycle in the array
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];

        tortoise = nums[tortoise];
        hare = nums[nums[hare]];

        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }

        tortoise = nums[0];
        //Find the entrance to the cycle
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }

}
