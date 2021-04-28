package topics.string;

/*
Given a string s, return the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:

Input: s = "leetcode"
Output: 0

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1
 */

//leetCode #387
public class FirstUniqueChar {
    public int firstUniqChar(String s) {
        int[] chars = new int[256];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
