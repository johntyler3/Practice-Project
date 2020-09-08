package topics.backtracking;

import java.util.ArrayList;
import java.util.List;

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
