package topics.math;

/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside
the signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21

Example 4:
Input: x = 0
Output: 0
 */

//leetCode #7
public class ReverseInteger {
    public int reverse(int x) {

        int newInt = 0;
        int pop;

        while (x != 0) {
            pop = x % 10;
            x /= 10;

            //the reason we have to make this check is because we should be given a 32-bit signed integer
            if (newInt > 0 && (Integer.MAX_VALUE - pop) / 10 < newInt) {
                return 0;
            }
            if (newInt < 0 && (Integer.MIN_VALUE - pop) / 10 > newInt) {
                return 0;
            }


            newInt = (newInt * 10) + pop;
        }

        return newInt;
    }
}
