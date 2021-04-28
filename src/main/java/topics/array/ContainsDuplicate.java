package topics.array;

import java.util.Arrays;
import java.util.HashSet;

/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false
 */

//leetCode #217
public class ContainsDuplicate {

    //this approach is a bit more costly with O(n) space used and O(n) time
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> mySet = new HashSet();

        for (int i = 0; i < nums.length; i++) {
            if (!mySet.add(nums[i])) {
                return true;
            }
        }
        return false;

    }

    //this approach is faster O(nlog(n)) for sorting the array at the beginning
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
