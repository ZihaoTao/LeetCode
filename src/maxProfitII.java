public class maxProfitII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        if(n == 0) return 0;
        for(int i = 0; i < n; i++) {
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, buy + prices[i]);
        }
        return sell;
    }
}
