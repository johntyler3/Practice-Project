package topics.math;

/*

Given an Array containing 9 numbers ranging from 1 to 10, write a method to find the missing number.
Assume you have 9 numbers between 1 to 10 and only one number is missing.


findMissingNumber({1,2,4,5,6,7,8,9,10}) --> 3
 */

//fireCode
public class FindMissingNumber {

    public static int findMissingNumber(int[] arr) {

        int add = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10;

        int myInt = 0;
        for (int i = 0; i < arr.length; i++) {
            myInt += arr[i];
        }

        return add - myInt;
    }

}
