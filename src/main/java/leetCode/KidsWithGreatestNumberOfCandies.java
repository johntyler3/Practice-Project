package leetCode;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > maxCandies) {
                maxCandies = candies[i];
            }
        }

        List<Boolean> output = new ArrayList<Boolean>();
        for (int i = 0; i < candies.length; i++) {
            if ((candies[i] + extraCandies) >= maxCandies) {
                output.add(true);
            } else {
                output.add(false);
            }
        }

        return output;
    }
}
