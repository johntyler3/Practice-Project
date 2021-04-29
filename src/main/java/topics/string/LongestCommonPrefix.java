package topics.string;

/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */

//leetCode #14
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        //get a common prefix between the first couple strings, then keep checking that prefix against all other strings
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            str = getCommonPrefix(str, strs[i]);
        }
        return str;
    }

    //gets a common prefix between str1 and str2
    public String getCommonPrefix(String str1, String str2) {
        int commonLength = Math.min(str1.length(), str2.length());
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < commonLength && (str1.charAt(index) == str2.charAt(index))) {
            sb.append(str1.charAt(index));
            index++;
        }
        return sb.toString();
    }

}
