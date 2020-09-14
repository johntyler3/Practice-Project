package topics.array;

/*
Given an array of integers, write a method - maxGain - that returns the maximum gain.
Maximum Gain is defined as the maximum difference between 2 elements in a list such that the larger
element appears after the smaller element. If no gain is possible, return 0.
 */

//fireCode
public class MaxGain {

    public static int maxGain(int[] a) {

        int max = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int tempMax = a[j] - a[i];
                if (tempMax > max) {
                    max = tempMax;
                }
            }
        }

        return max;
    }

}
