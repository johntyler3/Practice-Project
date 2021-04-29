package topics.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
 */

//leetCode #78
public class Subsets {

    //Input : nums = [1, 2, 3]
    //Output : <<3>, <2>, <1>, <1, 2, 3>, <1, 3>, <2, 3>, <1, 2>, <>>

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> myList = new ArrayList();
        generate(myList, new ArrayList(), nums, 0);
        return myList;
    }

    public void generate(List<List<Integer>> myList, List<Integer> curr, int[] nums, int start) {
        myList.add(new ArrayList(curr));
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            generate(myList, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }

    }

}
