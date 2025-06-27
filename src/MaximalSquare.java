package src;

public class MaximalSquare {

    private int minOfThree(int a, int b, int c){
        return Math.min(a, Math.min(b,c));
    }

    public int maximalSquare(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int max = 0;
        for(int i = 0 ; i < rows; i++){
            for(int j = 0 ; j < cols; j++){

                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j] - '0';
                }
                else if(matrix[i][j] == '1'){
                    dp[i][j] = minOfThree(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
                }

                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1'}};
        new MaximalSquare().maximalSquare(matrix);
    }
}
