package topics.string;

/*
Write a method that checks if a given integer is a palindrome - without allocating additional heap space
 */

//fireCode
public class IsIntegerPalindrome {

    public static Boolean isIntPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        String s = "" + x;
        int backIndex = s.length() - 1;

        for (int i = 0; i < (s.length() / 2); i++) {
            if (s.charAt(i) != s.charAt(backIndex)) {
                return false;
            }
            backIndex--;
        }


        return true;
    }

}
