package sorting;

import java.util.Arrays;

public class Quicksort {

    public static void main(String[] args) {
        int[] testArray = {1, 5, 3, 4, 2};
        quickSort(testArray);
        System.out.println(Arrays.toString(testArray));
    }


    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    //in this method we break the input array into n sub arrays
    //once the input array has been broken down to its smallest components, we partition the arrays
    //we select a pivot element that will work to divide the array into halves which we will iterate over
    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);
        quickSort(array, left, index - 1);
        quickSort(array, index, right);
    }

    //in the partition method we iterate over the left and right halves of the array up to the pivot element
    //we move the left and right pointers until we find elements that need to be swapped, then swap them
    public static int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }

            while (array[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
