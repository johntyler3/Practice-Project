package sorting;

import java.util.Arrays;

public class Insertionsort {

    public static void main(String[] args) {
        int[] testArray = {1, 5, 3, 4, 2, 9, 6, 7, 10, 8};
        insertionSortBetter(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    public static void insertionSort(int[] array) {
        //loop through the input
        for (int i = 1; i < array.length; i++) {
            int j = i;
            //if an element is found that is less than the element before it, swap it until its in the correct place
            while (array[j] < array[j - 1] && ((j - 1) >= 0)) {
                swap(array, j, j - 1);
                j = j -1;
            }
        }
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    //this version of insertion sort is a little bit faster because we avoid calling swap every time an element needs to be moved
    public static void insertionSortBetter(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;

            //instead of calling swap, save the element to be moved
            int value = array[i];

            //then move previous elements that are larger up one position
            while (array[j] > value && j >= 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            //and set the original element to the correct position
            array[j + 1] = value;
        }
    }

}
