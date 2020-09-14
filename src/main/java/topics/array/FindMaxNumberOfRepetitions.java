package topics.array;

/*
Given an Array of integers, write a method that will return the integer with the maximum number of repetitions.
Your code is expected to run with O(n) time complexity and O(1) space complexity.
The elements in the array are between 0 to size(array) - 1 and the array will not be empty.

f({3,1,2,2,3,4,4,4}) --> 4
 */

public class FindMaxNumberOfRepetitions {

    public static int getMaxRepetition(int[] a) {

        if (a == null) {
            return 0;
        }

        int length = a.length;

        for (int i = 0; i < a.length; i++) {
            a[a[i]%length] += length;
        }

        int max = 0;
        int maxVal = 0;
        for (int i = 0;  i < a.length; i++) {
            if (a[i] > maxVal) {
                max = i;
                maxVal = a[i];
            }
        }

        return max;
    }

}
