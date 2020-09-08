package topics.dynamicProgramming;

//leetCode #121
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minVal = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < minVal) {
                minVal = prices[i];
            } else if ((prices[i] - minVal) > maxProfit) {
                maxProfit = prices[i] - minVal;
            }

        }
        return maxProfit;
    }
}
