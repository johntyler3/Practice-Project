package topics.math;

/*
Write a method to determine whether a postive number is Happy.
A number is Happy (Yes, it is a thing!) if it follows a sequence that ends in 1 after following the steps given below :
Beginning with the number itself, replace it by the sum of the squares of its digits until
either the number becomes 1 or loops endlessly in a cycle that does not include 1.

For instance, 19 is a happy number. Sequence:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */

//fireCode
public class HappyNumbers {

    public static boolean isHappyNumber(int n) {
        int iterations = 0;

        while (true) {
            iterations++;
            n = checkNumber(n);
            if (n == 1) {
                return true;
            }

            if (iterations == 20) {
                break;
            }
        }

        return false;

    }

    private static int checkNumber(int n) {
        int returnVal = 0;

        while (n != 0) {
            int mod = n % 10;
            mod = mod * mod;

            n = n / 10;

            returnVal += mod;
        }

        return returnVal;
    }

}
