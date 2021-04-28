package topics.string;

/*
Write a function that reverses a string. The input string is given as an array of characters s.

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
 */

//leetCode #344
public class ReverseString {
    public void reverseString(char[] s) {
        int backIndex = s.length - 1;
        for(int i = 0; i < backIndex; i++) {
            swapIndex(s, i, backIndex);
            backIndex--;
        }
    }

    public void swapIndex(char[] s, int i1, int i2) {
        char temp = s[i1];
        s[i1] = s[i2];
        s[i2] = temp;
    }
}
