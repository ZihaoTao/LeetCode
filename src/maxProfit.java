public class maxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        int min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            // sell or not sell on ith day
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }
        return dp[prices.length - 1];
    }

    public int maxProfitII(int[] prices) {
        if(prices.length == 0 || prices.length == 1) return 0;

        int[] hold = new int[prices.length];
        int[] sell = new int[prices.length];
        hold[0] = -prices[0];
        hold[1] = Math.max(hold[0], sell[0] - prices[1]);
        sell[1] = Math.max(sell[0], hold[0] + prices[1]);
        for(int i = 2; i < prices.length; i++) {
            hold[i] = Math.max(hold[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], hold[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }

    public int maxProfitII2(int[] prices) {
        if(prices.length == 0)
            return 0;
        int hold = Integer.MIN_VALUE;
        int cash = 0;
        for(int price : prices) {
            cash = Math.max(cash, hold + price);
            hold = Math.max(hold, cash - price);
        }
        return cash;
    }

    public int maxProfitII3(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            if (prices[i] < prices[i + 1]) {
                res += prices[i + 1] - prices[i];
            }
        }
        return res;
    }
//一个是当前到达第i天可以最多进行j次交易，最好的利润是多少（global[i][j]），
//另一个是当前到达第i天，最多可进行j次交易，并且最后一次交易在当天卖出的最好的利润是多少（local[i][j]）。
    public int maxProfitIII(int[] prices) {
        if(prices.length == 0 || prices.length == 1) return 0;

        int[][] hold = new int[prices.length][3];
        int[][] sell = new int[prices.length][3];
        for(int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= 2; ++j) {
                hold[i][j] = Math.max(hold[i - 1][j] + diff, sell[i - 1][j - 1] + Math.max(diff, 0));
                sell[i][j] = Math.max(sell[i - 1][j], hold[i][j]);
            }
        }
        return sell[prices.length - 1][2];
    }

    public int maxProfitIII2(int[] prices) {
        if(prices.length == 0)
            return 0;
        int hold1 = Integer.MIN_VALUE;
        int cash1 = 0;
        int hold2 = Integer.MIN_VALUE;
        int cash2 = 0;
        for(int price : prices) {
            cash2 = Math.max(cash2, hold2 + price);
            hold2 = Math.max(hold2, cash1 - price);
            cash1 = Math.max(cash1, hold1 + price);
            hold1 = Math.max(hold1, -price);
        }
        return cash2;
    }
}
