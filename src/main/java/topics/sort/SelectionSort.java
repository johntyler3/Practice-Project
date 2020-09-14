package topics.sort;

/*
Selection sort offers improved performance over bubble sort, especially for arrays with a large number of elements.
Where bubble sort accumulated the largest elements towards the end of the array, selection sort accumulates
the smallest elements at the beginning of the array.

Write a method that uses the selection sort algorithm to sort an input array of integers.
 */

//fireCode
public class SelectionSort {

    public static int[] selectionSortArray(int[] arr){

        int newMin = 0;
        int minIndex = 0;
        int keepValue = 0;
        boolean swapIndex = false;

        for (int currentValue = 0; currentValue < arr.length; currentValue++) {
            newMin = arr[currentValue];
            for (int newValue = currentValue + 1; newValue < arr.length; newValue++) {
                if (arr[newValue] < newMin) {
                    newMin = arr[newValue];
                    minIndex = newValue;
                    swapIndex = true;
                }
            }
            if (swapIndex) {
                keepValue = arr[currentValue];
                arr[currentValue] = newMin;
                arr[minIndex] = keepValue;
            }
            swapIndex = false;
        }

        return arr;
    }

}
