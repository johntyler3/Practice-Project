package topics.math;

/*
Given an integer n, return the number of trailing zeroes in n!.

Follow up: Could you write a solution that works in logarithmic time complexity?



Example 1:
Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.

Example 2:
Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.

Example 3:
Input: n = 0
Output: 0
 */

//leetCode #172
public class FactorialTrailingZeros {

    /*

    We know that among all numbers of factorial, only numbers with factor 2 and 5 can produce a trailing zero (2*5 = 10),
    and that we will have much more factor 2's than factor 5's. So the key is to find the number of factor 5's we have in
    the factorial sequence, which is equivalent to the number of trailing zeros (the final solution to this problem).

    I used an example to deduce the solution:
    Suppose n = 100, then how many distinct numbers of factor 5 do we have?
    => We have 1*5, 2*5, 3*5, ..., 20*5, a total of 100/5 = 20 numbers.
    Among the numbers 1-20, there also exists factor 5.
    => We have 1*5, 2*5, ..., 4*5 a total of 20/5 = 4 numbers.
    And so on.

    Thus, given a number n, we can just repeat the following process:

     */


    public int trailingZeroes(int n) {
        int result = 0;
        while (n > 0) {
            result += n / 5;
            n /= 5;
        }
        return result;
    }
}
