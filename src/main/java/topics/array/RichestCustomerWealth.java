package topics.array;


/*
You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the ith​​​​
customer has in the jth​bank. Return the wealth that the richest customer has.
A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

Example 1:

Input: accounts = [[1,2,3],[3,2,1]]
Output: 6
Explanation:
1st customer has wealth = 1 + 2 + 3 = 6
2nd customer has wealth = 3 + 2 + 1 = 6
Both customers are considered the richest with a wealth of 6 each, so return 6.
 */

//leetCode #1672
public class RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {

        int bigMoney = 0;

        for (int i = 0; i < accounts.length; i++) {
            int currentMoney = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                currentMoney += accounts[i][j];
            }

            if (currentMoney > bigMoney) {
                bigMoney = currentMoney;
            }
        }

        return bigMoney;
    }

}
