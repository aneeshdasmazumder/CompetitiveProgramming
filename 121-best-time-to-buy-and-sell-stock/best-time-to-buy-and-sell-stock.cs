public class Solution {
    public int MaxProfit(int[] prices) {
        int maxProfit = 0;
        /*
        // Brute Force

        for(int i=0; i<prices.Length-1; i++) {
            int buy = prices[i];
            int sell = prices[i+1];
            for(int j=i+2; j<prices.Length; j++) {
                if(prices[j] > sell) {
                    sell = prices[j];
                    Console.WriteLine(prices[j] + " " +sell);
                }
            }

            if(sell > buy) {
                int profit = sell - buy;
                maxProfit = Math.Max(maxProfit, profit);
            }
        }
        */

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