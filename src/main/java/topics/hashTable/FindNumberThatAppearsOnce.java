package topics.hashTable;

import java.util.HashMap;

//fireCode
public class FindNumberThatAppearsOnce {

    public static int singleNumber(int[] A) {

        HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        if (A == null) {
            return 0;
        }

        for (int i = 0; i < A.length; i++) {
            if (myMap.containsKey(A[i])) {
                myMap.put(A[i], myMap.get(A[i]) + 1);
            } else {
                myMap.put(A[i], 1);
            }
        }

        for (Integer key : myMap.keySet()) {
            if (myMap.get(key).equals(1)) {
                return key;
            }
        }

        return 0;
    }

}
