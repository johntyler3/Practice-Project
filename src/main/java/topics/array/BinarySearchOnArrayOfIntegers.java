package topics.array;

//fireCode
public class BinarySearchOnArrayOfIntegers {

    public static Boolean binarySearch(int[] arr, int n){

        if (arr == null || arr.length == 0) {
            return false;
        } else if (arr.length == 1) {
            return arr[0] == n;
        }

        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (arr[mid] < n) {
                low = mid + 1;
            } else if (arr[mid] > n) {
                high = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }

}
