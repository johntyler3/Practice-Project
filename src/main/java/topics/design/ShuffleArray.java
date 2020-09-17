package topics.design;

import java.util.Random;

/*
Shuffle a set of numbers without duplicates.

This implementation uses the Fisher-Yates Algorithm :
    -   On each iteration of the algorithm, generate a random integer between the current index and the last index
    -   Then swap the elements at the current index and the chosen index
    -   It is possible to swap an element with itself
 */

//leetCode #384
public class ShuffleArray {

    private int[] array;
    private int[] original;

    Random rand = new Random();

    public ShuffleArray(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
