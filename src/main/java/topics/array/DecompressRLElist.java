package topics.array;

import java.util.ArrayList;
import java.util.List;

//leetCode #1313
public class DecompressRLElist {

    public int[] decompressRLElist(int[] nums) {

        ArrayList<Integer> myList = new ArrayList();

        for (int i = 0; i < nums.length; i +=2) {
            int addElement = nums[i + 1];
            for (int j = 0; j < nums[i]; j++) {
                myList.add(addElement);
            }
        }

        return getArray(myList);
    }

    public int[] getArray(List<Integer> list) {
        int[] returnArray = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            returnArray[i] = list.get(i);
        }

        return returnArray;
    }

}
