package topics.design;

import java.util.HashMap;
import java.util.Random;

/*
Implement the RandomizedSet class:

    -   bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
    -   bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
    -   int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
    -   Follow up: Could you implement the functions of the class with each function works in average O(1) time?
 */

//leetCode #380
public class RandomizedSet {

    //maps values to index
    HashMap<Integer, Integer> keyMap = new HashMap();

    //maps index to values
    HashMap<Integer, Integer> indexMap = new HashMap();

    Random rand = new Random();

    int count = 0;

    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (keyMap.containsKey(val)) {
            return false;
        } else {
            keyMap.put(val, count);
            indexMap.put(count, val);
            count = keyMap.size();
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!keyMap.containsKey(val)) {
            return false;
        } else {
            //remove the value from the keyMap and save it's index
            int originalIndex = keyMap.get(val);
            keyMap.remove(val);

            //if the value is not the last element in the index map
            if (originalIndex != indexMap.size() - 1) {
                //save the value of the last element in the index map
                Integer lastIndexValue = indexMap.get(indexMap.size() - 1);

                //overwrite the original index in indexMap with last value
                indexMap.put(originalIndex, lastIndexValue);

                //overwrite the last value in keyMap with original index
                keyMap.put(lastIndexValue, originalIndex);

                //remove the last element in index map
                indexMap.remove(indexMap.size() - 1);
            } else {
                indexMap.remove(originalIndex);
            }
            count = keyMap.size();
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = rand.nextInt(count);
        return indexMap.get(index);
    }

}
