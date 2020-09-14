package topics.string;

/*
A palindrome is a string or sequence of characters that reads the same backward as forward. For example,
"madam" is a palindrome. Write a method that takes in a String and returns a boolean -> true if the
input String is a palindrome and false if it is not. An empty string and a null input are considered
palindromes. You also need to account for the space character. For example, "race car" should return false
as read backward it is "rac ecar".
 */

//fireCode
public class PalindromeTester {

    public static boolean isStringPalindrome(String str){

        if (str == null || str.length() == 0) {
            return true;
        }

        int backIndex = str.length() - 1;
        for (int i = 0; i < (str.length() / 2); i++) {
            if (str.charAt(i) != str.charAt(backIndex)) {
                return false;
            }
            backIndex--;
        }

        return true;
    }

}
