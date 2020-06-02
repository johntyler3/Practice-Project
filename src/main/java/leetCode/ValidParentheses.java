package leetCode;

import java.util.Stack;

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
