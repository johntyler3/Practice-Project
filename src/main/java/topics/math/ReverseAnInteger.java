package topics.math;

/*
Implement a method that reverses an integer - without using additional heap space
 */

//fireCode
public class ReverseAnInteger {

    public static int reverseInt(int x) {
        int myInt = 0;

        while (x != 0) {
            myInt *= 10;
            myInt += x % 10;
            x = x / 10;
        }


        return myInt;
    }

}
