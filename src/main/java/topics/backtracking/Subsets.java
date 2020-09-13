package topics.backtracking;

import java.util.ArrayList;
import java.util.List;

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