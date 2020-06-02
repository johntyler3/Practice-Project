package leetCode;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicates {

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
