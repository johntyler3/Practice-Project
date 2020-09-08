package topics.array;

import java.util.ArrayList;
import java.util.List;

//leetCode 1389
public class CreateTargetArrayInOrder {

    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> list = new ArrayList();

        for (int i = 0;  i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }

        return getArray(list);
    }

    private int[] getArray(List<Integer> list) {
        int[] ret = new int[list.size()];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }

        return ret;
    }

}
