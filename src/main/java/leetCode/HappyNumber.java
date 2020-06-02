package leetCode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> mySet = new HashSet();
        mySet.add(n);

        int newHappy = n;
        boolean notHappy = true;
        while (notHappy) {
            int squaredSum = 0;
            int totalSum = 0;
            while (newHappy > 0) {
                squaredSum = newHappy % 10;
                totalSum += (squaredSum * squaredSum);
                newHappy /= 10;
            }
            if (totalSum == 1) {
                return true;
            }
            newHappy = totalSum;
            if(!mySet.add(newHappy)) {
                return false;
            }
        }
        return false;
    }
}
