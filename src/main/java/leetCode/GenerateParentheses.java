package leetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> myList = new ArrayList();
        if (n > 0) {
            generate(myList, "", n, n);
        }
        return myList;
    }

    public void generate(List<String> myList, String paren, int left, int right) {
        if (left == 0 && right == 0) {
            myList.add(paren);
        } else {
            if (left > 0) {
                generate(myList, paren + "(", left - 1, right);
            }

            if (right > left) {
                generate(myList, paren + ")", left, right - 1);
            }
        }
    }
}
