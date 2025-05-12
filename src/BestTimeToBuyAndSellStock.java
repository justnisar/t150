package src;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minimumPriceTillNow = prices[0];
        for(int i = 1 ; i < prices.length ; i++){

            if(prices[i] - minimumPriceTillNow > maxProfit){
                maxProfit = prices[i] - minimumPriceTillNow;
            }

            if(prices[i] < minimumPriceTillNow){
                minimumPriceTillNow = prices[i];
            }

        }
        return maxProfit;
    }
}
