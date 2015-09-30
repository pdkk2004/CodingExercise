package Leetcode;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        
        int max = 0;
        int min = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                int profit = prices[i] - min;
                max = max > profit ? max : profit;
            }
        }
        return max;
    }
}
