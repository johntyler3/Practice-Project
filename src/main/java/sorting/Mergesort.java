package sorting;

public class Mergesort {

    public static void mergesort(int[] array) {
        mergesort(array, array.length);
    }

    //here we recursively break up the input array into n sub array halves
    //once we have broken the array into its smallest components, we can start to merge the pieces back together by calling mergeHalves
    public static void mergesort(int[] array, int length) {
        if (length < 2) {
            return;
        }

        int mid = length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[length - mid];

        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }

        for (int i = mid; i < length; i++) {
            rightArray[i - mid] = array[i];
        }

        mergesort(leftArray, mid);
        mergesort(rightArray, length - mid);
        mergeHalves(array, leftArray, rightArray, mid, length - mid);
    }

    //in this method we compare the elements from the two halves, and put the smaller element into the input array
    public static void mergeHalves(int[] array, int[] leftArray, int[] rightArray, int leftLength, int rightLength) {

        int leftIndex = 0;
        int rightIndex = 0;
        int inputIndex = 0;

        while(leftIndex < leftLength && rightIndex < rightLength) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                array[inputIndex++] = leftArray[leftIndex++];
            } else {
                array[inputIndex++] = rightArray[rightIndex++];
            }
        }

        //once we are done comparing the array halves, one of the two indexes will still be less than its length
        //just add all remaining elements from that half into the array

        while (leftIndex < leftLength) {
            array[inputIndex++] = leftArray[leftIndex++];
        }

        while (rightIndex < rightLength) {
            array[inputIndex++] = rightArray[rightIndex++];
        }

    }
}
