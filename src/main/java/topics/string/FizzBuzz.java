package topics.string;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer n, return a string array answer (1-indexed) where:

answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i if non of the above conditions are true.


Example 1:

Input: n = 3
Output: ["1","2","Fizz"]
Example 2:

Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]
 */

//leetCode #412
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> returnList = new ArrayList();
        if (n <= 0) {
            return returnList;
        }
        String fizz = "Fizz";
        String buzz = "Buzz";
        String fizzBuzz = "FizzBuzz";

        for (int i = 1; i < n + 1; i++) {
            if ((i % 3) == 0 && ((i % 5) == 0)) {
                returnList.add(fizzBuzz);
            } else if (i % 5 == 0) {
                returnList.add(buzz);
            } else if (i % 3 == 0) {
                returnList.add(fizz);
            } else {
                returnList.add(i + "");
            }
        }

        return returnList;
    }
}
