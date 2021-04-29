package topics.string;

/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:
What should we return when needle is an empty string? This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().



Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1

Example 3:
Input: haystack = "", needle = ""
Output: 0
 */


//leetCode #28
public class ImplementStrStr {

    //probably not allowed for this problem
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        return haystack.indexOf(needle);
    }

    //a better solution still running in brute force O(N^2) time
    public int strStrBetter(String haystack, String needle) {
        // empty needle appears everywhere, first appears at 0 index
        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 0)
            return -1;


        for (int i = 0; i < haystack.length(); i++) {
            // no enough places for needle after i
            if (i + needle.length() > haystack.length()) break;

            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
                if (j == needle.length()-1)
                    return i;
            }
        }

        return -1;
    }

    //fist attempt at this solution, the brute force solution runs in O(N^2) time
    public static int strStrTest(String haystack, String needle) {

        if (needle.length() == 0 &&  haystack.length() > 0) {
            return 0;
        } else if (haystack == null || (haystack.length() == 0 &&  needle.length() > 0)) {
            return -1;
        } else if (needle.length() == 0 && haystack.length() == 0) {
            return 0;
        }


        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (checkString(haystack.substring(i), needle)) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static boolean checkString(String s1, String s2) {
        int s1Index = 0;
        for (char ch : s2.toCharArray()) {
            if (s1Index > s1.length() - 1 || s1.charAt(s1Index) != ch) {
                return false;
            }
            s1Index++;
        }

        return true;
    }

    public static void main(String[] args) {
        strStrTest("aaa", "aaaa");
    }
}
