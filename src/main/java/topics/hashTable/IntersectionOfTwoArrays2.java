package topics.hashTable;

import java.util.ArrayList;
import java.util.HashMap;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result
must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 */

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
