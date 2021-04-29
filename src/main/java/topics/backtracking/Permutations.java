package topics.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]
 */

//leetCode #46
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if (nums != null) {
            getPerms(res, new ArrayList(), nums);
        }
        return res;
    }

    public void getPerms(List<List<Integer>> res, List<Integer> perm, int[] nums) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList(perm));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!perm.contains(nums[i])) {
                    perm.add(nums[i]);
                    getPerms(res, perm, nums);
                    perm.remove(perm.size() - 1);
                }
            }
        }
    }

}
