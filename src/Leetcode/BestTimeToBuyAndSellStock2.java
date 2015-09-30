package Leetcode;

public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int prof = 0;
        int l = prices.length;
        if (l <= 1) {
            return prof;
        }
        for (int i = 1; i < l; i++) {
            if (prices[i] > prices[i - 1]) {
                prof += prices[i] - prices[i - 1];
            }
        }
        return prof;
    }
}
