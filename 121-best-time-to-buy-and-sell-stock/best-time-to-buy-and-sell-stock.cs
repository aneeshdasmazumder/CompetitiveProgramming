public class Solution {
    public int MaxProfit(int[] prices) {
        int maxProfit = 0;

        // Optimized
        int buy = prices[0];

        for(int i=1; i<prices.Length; i++) {
            if(buy > prices[i]) {
                buy = prices[i];
            } else {
                maxProfit = Math.Max(maxProfit, (prices[i]-buy));
            }
        }

        return maxProfit;
    }
}