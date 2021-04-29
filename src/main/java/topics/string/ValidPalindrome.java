package topics.string;

/*
Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
 */

//leetCode #125
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int backChar = s.length() - 1;
        int frontChar = 0;

        while (frontChar <= backChar) {
            Character front = Character.toLowerCase(s.charAt(frontChar));
            Character back = Character.toLowerCase(s.charAt(backChar));

            if (!(Character.isDigit(front) || Character.isLetter(front))) {
                frontChar++;
            } else if (!(Character.isDigit(back) || Character.isLetter(back))) {
                backChar--;
            } else if (!(front.equals(back))){
                return false;
            } else {
                frontChar++;
                backChar--;
            }
        }


        return true;
    }

}
