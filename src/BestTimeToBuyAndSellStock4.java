package src;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock4 {

    public int maxProfit(int k, int[] prices) {

        if(prices == null || prices.length < 2){
            return 0;
        }

        int[] cost = new int[k];
        Arrays.fill(cost, Integer.MAX_VALUE);
        int[] profit = new int[k];

        for(int price : prices){
            cost[0] = Math.min(cost[0], price);
            profit[0] = Math.max(profit[0], price - cost[0]);
            for(int i = 1 ; i < k ; i++){
                cost[i] = Math.min(cost[i], price - profit[i-1]);
                profit[i] = Math.max(profit[i], price - cost[i]);
            }
        }

        return profit[k-1];
    }
}
