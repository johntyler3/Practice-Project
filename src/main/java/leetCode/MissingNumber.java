package leetCode;

public class MissingNumber {

    /*
    Gauss' Rule :
	The sum of natural numbers from 0 to n is equal to (n * (n - 1) / 2)
	This algorithm is useful when determining a missing number from a sequence of numbers quickly
    It allows us to find a missing number without using extra space to find the number

     */

    public int missingNumber(int[] nums) {
        int runningTotal = 0;
        for (int i = 0; i < nums.length; i++) {
            runningTotal += nums[i];
        }

        int n = nums.length + 1;

        return (n * (n - 1) / 2) - runningTotal;
    }
}
