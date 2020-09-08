package topics.hashTable;

import java.util.ArrayList;
import java.util.HashMap;

//leetCode #350
public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return intersect(nums2, nums1);
        }

        HashMap<Integer, Integer> map = new HashMap();
        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        ArrayList<Integer> myList = new ArrayList();
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                myList.add(i);
                map.put(i, map.get(i) - 1);
            }
        }

        int[] returnArray = new int[myList.size()];
        for (int i = 0; i < myList.size(); i++) {
            returnArray[i] = myList.get(i);
        }

        return returnArray;
    }
}
