package topics.hashTable;

import java.util.HashMap;

/*
Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:
0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0


Example 1:
Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
Output: 2
Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0

Example 2:
Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
Output: 1
 */

//leetCode #454
public class FourSumII {

    /*
        -   I learned about using this Map method called map.getOrDefault(Object key, Value v)
        -   this method will get the value of the key if the map has it, or will return the default value if not

        This cleans up the following common code :
        int key = A[i] + B[j];
        if (map.containsKey(key)) {
            map.put(map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
        map.put(key, map.getOrDefault(key, 0) + 1);

        into -->

        int key = A[i] + B[j];
        map.put(key, map.getOrDefault(key, 0) + 1);
     */

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int key = A[i] + B[j];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        int result = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                result += map.getOrDefault((-1 * sum), 0);
            }
        }

        return result;
    }

}
