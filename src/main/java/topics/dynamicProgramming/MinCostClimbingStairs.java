package topics.dynamicProgramming;

/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the floor.

Example 1:
Input: cost = [10,15,20]
Output: 15
Explanation: Cheapest is: start on cost[1], pay that cost, and go to the top.

Example 2
Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: Cheapest is: start on cost[0], and only step on 1s, skipping cost[3].
 */

public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length - 1 == 2) {
            return Math.min(cost[0] + cost[2], cost[1]);
        }

        int[] totalCost = new int[cost.length + 1];

        totalCost[0] = cost[0];
        totalCost[1] = cost[1];

        for (int i = 2; i <= cost.length; i++) {
            int minVal = Math.min(totalCost[i - 1], totalCost[i - 2]);
            if (i == cost.length ) {
                totalCost[i] += minVal;
            } else {
                totalCost[i] += cost[i] + minVal;
            }
        }

        return totalCost[cost.length];

    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }

}
