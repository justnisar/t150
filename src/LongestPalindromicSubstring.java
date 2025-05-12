package src;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];
        String result = null;

        // for strings with length 1
        for(int i = 0 ; i < s.length() ; i++) {
            dp[i][i] = true;
            result = s.substring(i, i + 1);
        }

        // for strings with length 2
        for(int i = 0 ; i < s.length() - 1 ; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                result = s.substring(i, i + 2);
                dp[i][i+1] = true;
            }
        }

        // for all other strings
        for(int i = 2 ; i < s.length() ; i++ ){

            for(int j = 0 ; j + i < s.length() ; j++){

                if(s.charAt(j) == s.charAt(j + i) && dp[j+1][j+i-1]){
                    result = s.substring(j, j + i + 1);
                    dp[j][j+i] = true;
                }

            }

        }

        return result;
    }

    public static void main(String[] args) {
        new LongestPalindromicSubstring().longestPalindrome("babad");
    }
}
