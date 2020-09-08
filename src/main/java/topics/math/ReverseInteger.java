package topics.math;

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
