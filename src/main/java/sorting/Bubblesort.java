package sorting;

import java.util.Arrays;

public class Bubblesort {

    public static void main(String[] args) {
        int[] testArray = {1, 5, 3, 4, 2, 9, 6, 7, 10, 8};
        bubbleSort(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    public static void bubbleSort(int[] array) {
        boolean sorted = false;

        //loop over array while still not sorted
        while (!sorted) {
            int index = 1;
            sorted = true;
            while (index < array.length) {
                //if we find elements out of order, swap them and make sorted boolean false
                if (array[index] < array[index - 1]) {
                    swap(array, index, index - 1);
                    sorted = false;
                }
                index++;
            }
        }
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
