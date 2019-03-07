public class maxProfitV {
    public int maxProfit(int[] prices, int fee) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        for(int i = 0; i < prices.length; i++) {
            buy = Math.max(buy, sell - fee - prices[i]);
            sell = Math.max(sell, buy + prices[i]);
        }
        return sell;
    }
}
