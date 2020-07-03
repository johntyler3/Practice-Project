package sorting;

import java.util.Arrays;

public class Selectionsort {

    public static void main(String[] args) {
        int[] testArray = {1, 5, 3, 4, 2, 9, 6, 7, 10, 8};
        selectionSort(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    public static void selectionSort(int[] array) {
        //loop over input elements
        for (int i = 0; i < array.length; i++) {
            //keep track of the current minimum element index
            int minIndex = i;

            //loop over the rest of the elements, trying to find something smaller
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            //if a smaller element was found, swap the elements
            if (minIndex != i) {
                swap(array, i, minIndex);
            }
        }
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
