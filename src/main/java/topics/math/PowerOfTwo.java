package topics.math;

//fireCode
public class PowerOfTwo {

    public static boolean isPowOfTwo(int num) {

        if (num == 1) {
            return true;
        }

        return (num % 2 == 0);

    }
}
