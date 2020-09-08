package topics.hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetCode #169
public class MajorityElement {

    //Takes O(N) time
    //Takes O(N) space
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap();

        for (int i : nums) {
            if (numMap.containsKey(i)) {
                numMap.put(i, numMap.get(i) + 1);
            } else {
                numMap.put(i, 1);
            }
        }

        for (int i : numMap.keySet()) {
            if (numMap.get(i) > nums.length / 2) {
                return i;
            }
        }
        return -1;
    }

    //Arrays.sort runs in O(N log(N)) which is faster than O(N)
    //Takes O(1) space
    public int majorityElementSortingMethod(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

}
