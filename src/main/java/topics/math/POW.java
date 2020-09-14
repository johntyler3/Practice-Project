package topics.math;

/*
Write a method - pow(x,n) that returns the value of x raised to the power of n (xn). n can be negative!
 */

//fireCode
public class POW {

    public static double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double original = x;

        if (n < 0) {
            for (int i = 1; i > n; i--) {
                x *= (1/original);
            }
        } else {
            for (int i = 1; i < n; i++) {
                x *= original;
            }
        }

        return x;
    }

}
