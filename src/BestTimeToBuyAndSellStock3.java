package src;

public class BestTimeToBuyAndSellStock3 {

    public int maxProfit(int[] prices) {

        if(prices == null || prices.length < 2){
            return 0;
        }

        int t1Cost = Integer.MAX_VALUE;
        int t1Profit = 0;
        int t2Cost = Integer.MAX_VALUE;
        int t2Profit = 0;

        for(int price : prices){

            t1Cost = Math.min(t1Cost, price);
            t1Profit = Math.max(t1Profit, price - t1Cost);
            t2Cost = Math.min(t2Cost, price - t1Profit);
            t2Profit = Math.max(t2Profit, price - t2Cost);
        }

        return t2Profit;
    }

}
