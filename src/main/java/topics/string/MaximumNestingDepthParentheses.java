package topics.string;

//leetCode #1614
public class MaximumNestingDepthParentheses {

    /*
    For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.
    Given a VPS represented as string s, return the nesting depth of s
    It is guaranteed that parentheses expression s is a VPS.
     */

    public int maxDepth(String s) {
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                count++;
            }

            if (count > maxCount) {
                maxCount = count;
            }

            if (ch == ')') {
                count--;
            }
        }

        return maxCount;
    }
}
