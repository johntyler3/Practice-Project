package topics.array;

/*
Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.

A subarray is a contiguous subsequence of the array.
Return the sum of all odd-length subarrays of arr.

Example 1:
Input: arr = [1,4,2,5,3]
Output: 58
Explanation: The odd-length subarrays of arr and their sums are:
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58

Example 2:
Input: arr = [1,2]
Output: 3
Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.

Example 3:
Input: arr = [10,11,12]
Output: 66
 */

//leetCode #1588
public class SumOfAllOddLengthSubarrays {


    /*
    Initial approach - loop over oddLength, loop over array, loop over adding values (pretty slow)
     */
    public int sumOddLengthSubarrays(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int oddLengthCounter = 1;
        int sum =  0;


        while (oddLengthCounter <= arr.length) {
            for (int i = 0; i < arr.length; i++) {
                sum += getSubArraySum(arr, i, oddLengthCounter + i);
            }
            oddLengthCounter += 2;
        }
        return sum;
    }

    public int getSubArraySum(int[] arr, int beg,  int end) {
        int sum  = 0;
        if (beg >= 0  && end <= arr.length) {
            for (int i = beg; i < end; i++) {
                sum += arr[i];
            }
        }

        return sum;
    }

}
