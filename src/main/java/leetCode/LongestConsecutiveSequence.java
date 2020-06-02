package leetCode;

import java.util.HashSet;

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
