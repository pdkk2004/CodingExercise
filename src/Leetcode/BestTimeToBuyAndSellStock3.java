package Leetcode;

public class BestTimeToBuyAndSellStock3 {
    public int maxProfit(int[] prices) {
        int l = prices.length;
        if (l < 2) {
            return 0;
        }
        
        int min = prices[0];
        int[] P = new int[l];
        int profit = 0;
        for (int i = 1; i < l; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            int temp = prices[i] - min;
            if (temp > profit) {
                profit = temp;
            }
            P[i] = profit;
        }
        
        int maxSum = 0;
        int max = prices[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            } else {
                int sum = max - prices[i] + P[i];
                maxSum = sum > maxSum ? sum : maxSum;
            }
        }
        return maxSum;
    }
}
