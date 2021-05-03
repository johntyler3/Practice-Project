package topics.string;

/*
Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

Example 1:
Input: "Hello"
Output: "hello"

Example 2:
Input: "here"
Output: "here"

Example 3:
Input: "LOVELY"
Output: "lovely"
 */

//leetCode #709
public class ToLowerCase {

    /*
    **NOTE** in ASCII 'A' is 65 decimal and 'Z' is 90, 'a' is 97 and 'z' is 122
    * to get from A to a we have to add 32 (97 - 65)
     */

    public String toLowerCase(String str) {
        char[] chArray = str.toCharArray();
        for (int i = 0; i < chArray.length; i++) {
            if (chArray[i] >= 'A' && chArray[i] <= 'Z') {
                chArray[i] += 32;
            }
        }
        return String.valueOf(chArray);
    }

}
