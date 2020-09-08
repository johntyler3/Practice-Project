package topics.string;

import java.util.ArrayList;
import java.util.List;

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
