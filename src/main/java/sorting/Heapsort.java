package sorting;

import java.util.Arrays;

public class Heapsort {

    public static void main(String[] args) {
        int[] testArray = {1, 5, 3, 4, 2};
        heapsort(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    public static void heapsort(int[] array) {
        int length = array.length;

        //Build max heap
        for (int i = (length / 2) - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        //Heap sort
        for (int i = length - 1; i >= 0; i--) {
            swap(array, i, 0);

            //Heapify root element
            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int length, int i) {
        //Find the largest among root, left child and right child
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < length && array[left] > array[largest]) {
            largest = left;
        }

        if (right < length && array[right] > array[largest]) {
            largest = right;
        }

        //Swap and continue heapifying if root is not largest
        if (largest != i) {
            swap(array, i, largest);
            heapify(array, length, largest);
        }
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
