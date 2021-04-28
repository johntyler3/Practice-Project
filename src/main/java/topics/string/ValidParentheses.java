package topics.string;

import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([)]"
Output: false

Example 5:
Input: s = "{[]}"
Output: true
 */

//leetCode #20
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        } else if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> charStack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')' || ch == ']' || ch == '}') {
                if (charStack.isEmpty()) {
                    return false;
                } else {
                    char check = charStack.pop();
                    if ((ch == ')' && check != '(') || (ch == ']' && check != '[') || (ch == '}' && check != '{')) {
                        return false;
                    }
                }
            } else {
                charStack.push(ch);
            }
        }

        if (charStack.isEmpty()) {
            return true;
        } return false;
    }
}
