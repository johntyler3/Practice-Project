package topics.bitManipulation;

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
 */

//leetCode #136
public class SingleNumber {

    /*
    Concept
    If we take XOR of zero and some bit, it will return that bit
    If we take XOR of two same bits, it will return 0
    So we can XOR all bits together to find the unique number.
     */

    public int singleNumber(int[] nums) {
        int singleNum = 0;
        for (int i : nums) {
            singleNum ^= i;
        }
        return singleNum;
    }
}
