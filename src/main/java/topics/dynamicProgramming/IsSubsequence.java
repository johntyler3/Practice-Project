package topics.dynamicProgramming;

/*
Given two strings s and t, check if s is a subsequence of t.
A subsequence of a string is a new string that is formed from the original
string by deleting some (can be none) of the characters without disturbing
the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false
 */

import java.util.Arrays;
import java.util.Stack;

//leetCode #392
public class IsSubsequence {

    /*
    Initial approach : use a stack and loop over characters
    */

    public boolean isSubsequence(String s, String t) {
        Stack<Character> charStack = new Stack();

        for (int i = t.length() - 1; i >= 0;  i--) {
            charStack.push(t.charAt(i));
        }



        for (char ch : s.toCharArray()) {
            boolean found = false;
            if (!charStack.isEmpty()) {
                while (!charStack.isEmpty()) {
                    char newChar = charStack.pop();
                    if(newChar == ch) {
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }

    /*
    Dynamic Programming Approach slow but useful to know
     */

    public static boolean isSubsequence2(String s, String t) {
        int[][] dp = new int[t.length()+1][s.length()+1];
        for (int i = 0; i <= t.length(); i++) {
            for (int j = 0; j <= s.length(); j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else {
                    //if the character is found, update dp array
                    if (s.charAt(j - 1) == t.charAt(i - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    }
                    else {
                        //take the maximum value between last row / column
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }

                }
            }
        }

        print(dp);
        return dp[t.length()][s.length()] == s.length();
    }

    private static void print(int[][] dp) {
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
    }

    /*
    Pointers very fast
     */

    public static boolean isSubsequence3(String s, String t) {

        int tIndex = 0;


        for (char ch : s.toCharArray()) {
            boolean found = false;
            while (tIndex < t.length()) {
                if (ch == t.charAt(tIndex)) {
                    tIndex++;
                    found = true;
                    break;
                }
                tIndex++;
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        isSubsequence3("aaaaa", "bbaaa");
    }

}
