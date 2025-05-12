package src;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        dp[0] = 0;

        for (int i = 1; i < amount + 1; i++) {

            int temp = Integer.MAX_VALUE;
            for(int denomination : coins){

                if(i - denomination < 0){
                    continue;
                }
                if(dp[i - denomination] == -1){
                    continue;
                }

               temp = Math.min(1 + dp[i - denomination], temp);


            }
            dp[i] = temp == Integer.MAX_VALUE ? -1 : temp;
        }


        return dp[amount];
    }

    public static void main(String[] args) {

        int[] denominations = {2,5,10,1};
        new CoinChange().coinChange(denominations, 27);
    }
}
