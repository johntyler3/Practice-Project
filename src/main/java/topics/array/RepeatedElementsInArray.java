package topics.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Write a method duplicate to find the repeated or duplicate elements in an array.
This method should return a list of repeated integers in a string with the elements sorted in ascending order (as illustrated below).

duplicate({1,3,4,2,1}) --> "[1]"
duplicate({1,3,4,2,1,2,4}) --> "[1, 2, 4]"

Note: You may use toString() method to return the
standard string representation of most data structures, and
Arrays.sort() to sort your result.
 */

//fireCode
public class RepeatedElementsInArray {

    public static String duplicate(int[] numbers){

        Map<Integer, Integer> intMap = new HashMap<Integer, Integer>();
        List<Integer> intList = new ArrayList();

        for (int i = 0; i < numbers.length; i++) {
            if (intMap.containsKey(numbers[i])) {
                intMap.put(numbers[i], numbers[i] + 1);
            } else {
                intMap.put(numbers[i], 1);
            }
        }

        for (int i : intMap.keySet()) {
            if (intMap.get(i) > 1) {
                intList.add(i);
            }
        }

        return intList.toString();
    }

}
