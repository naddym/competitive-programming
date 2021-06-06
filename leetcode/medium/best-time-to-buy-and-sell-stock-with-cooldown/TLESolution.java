/**
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]

Example 2:

Input: prices = [1]
Output: 0
 
Constraints:

1 <= prices.length <= 5000
0 <= prices[i] <= 1000

*/

class TLESolution {
    public int maxProfit(int[] prices) {
        return maxProfit(0, Transaction.BUY, prices);   
    }
    
    private int maxProfit(int i, Transaction type, int[] prices) {
        int profit = 0;
        if (i >= prices.length) {
            return profit;
        }
        
        if (type == Transaction.BUY) {
            int buy = maxProfit(i + 1, Transaction.SELL, prices) - prices[i];
            int notBuy = maxProfit(i + 1, Transaction.BUY, prices);
            profit = Math.max(buy, notBuy);    
        } else {
            int sell = maxProfit(i + 2, Transaction.BUY, prices) + prices[i];
            int notSell = maxProfit(i + 1, Transaction.SELL, prices);
            profit = Math.max(sell, notSell);
        }
        
        return profit;
    }
    
    private enum Transaction {
        BUY, SELL;
    }
}