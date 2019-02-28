public class maxProfitIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // if k > n / 2, can buy and sell as many as possible
        if (k > n / 2) {
            int buy = Integer.MIN_VALUE;
            int sell = 0;
            for (int i = 0; i < n; i++) {
                buy = Math.max(buy, sell - prices[i]);
                sell = Math.max(sell, buy + prices[i]);
            }
            return sell;
        }

        int[] buy = new int[k + 1];
        for (int i = 0; i < buy.length; i++) {
            buy[i] = Integer.MIN_VALUE;
        }
        int[] sell = new int[k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k];
    }
}
