package topics.sort;

/*
Write a method that takes in an array of ints and uses the Bubble Sort algorithm to sort the array 'in place' in ascending order.
The method should return the same, in-place sorted array.

Note: Bubble sort is one of the most inefficient ways to sort a large array of integers.
Nevertheless, it is an interview favorite. Bubble sort has a time complexity of O(n2).
However, if the sample size is small, bubble sort provides a simple implementation of a classic sorting algorithm.
 */

//fireCode
public class BubbleSort {

    public static int[] bubbleSortArray(int[] arr){

        boolean sorted = false;

        while (!sorted) {

            int index = 1;
            sorted = true;
            while (index < arr.length) {
                if (arr[index] < arr[index - 1]) {
                    swap(arr, index, index - 1);
                    sorted = false;
                }
                index++;
            }
        }


        return arr;
    }


    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
