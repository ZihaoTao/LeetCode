public class maxProfitVI {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = - prices[0];
        buy[1] = Math.max(buy[0],sell[0] - prices[1]);
        sell[1] = Math.max(sell[0], buy[0] + prices[1]);
        for(int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length, buy = Integer.MIN_VALUE, sell = 0, presell = 0;
        for(int i = 0; i < n; i++) {
            int oldSell = sell; // sell of day before yesterday
            buy = Math.max(buy, presell - prices[i]);
            sell = Math.max(oldSell, buy + prices[i]);
            presell = oldSell;
        }
        return sell;
    }
}
