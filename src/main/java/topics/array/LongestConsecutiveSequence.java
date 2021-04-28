package topics.array;

import java.util.HashSet;

/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */

//leetCode #128
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int consecutiveElements = 1;
        int maxConsecutive = 1;

        HashSet<Integer> mySet = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            mySet.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int searchNum = nums[i] + 1;
            int lessNum = nums[i] - 1;
            if (!mySet.contains(lessNum)) {
                while (mySet.contains(searchNum)) {
                    searchNum++;
                    consecutiveElements++;
                }
                maxConsecutive = Math.max(consecutiveElements, maxConsecutive);

                consecutiveElements = 1;
            }
        }

        return maxConsecutive;
    }

}
