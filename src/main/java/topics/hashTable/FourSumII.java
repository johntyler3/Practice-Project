package topics.hashTable;

import java.util.HashMap;

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
