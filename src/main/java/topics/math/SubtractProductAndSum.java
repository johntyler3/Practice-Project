package topics.math;

//leetCode #1281
public class SubtractProductAndSum {

    public int subtractProductAndSum(int n) {
        int productDigits = 1;
        if (n == 0) {
            productDigits = 0;
        }

        int sumDigits = 0;

        while (n > 0) {
            int digit = n % 10;
            productDigits *= digit;
            sumDigits += digit;
            n /= 10;
        }

        return productDigits - sumDigits;
    }

}
