package src;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int rows = s1.length() + 1;
        int cols = s2.length() + 1;
        boolean[][] dp = new boolean[rows][cols];
        dp[0][0] = true;

        // rows
        for(int i = 1 ; i < rows ; i++){
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }

        // cols
        for(int j = 1 ; j < cols ; j++){
            dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
        }

        for(int i = 1 ; i < rows ; i++){
            for(int j = 1 ; j < cols; j++){

                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));

            }
        }

        return dp[rows-1][cols-1];
    }

}
