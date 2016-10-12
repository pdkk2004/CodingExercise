package Leetcode;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int l = coins.length;
        int[] N = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < l; j++) {
                if (i >= coins[j] && N[i - coins[j]] >= 0) {
                    min = Math.min(N[i - coins[j]] + 1, min);
                }
            }
            N[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return N[amount] == Integer.MAX_VALUE ? -1 : N[amount];
    }
}
