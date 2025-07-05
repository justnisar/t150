package src;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];

        dp[0][0] = true;

        String result = "";

        // Strings of length 1 and 2
        for(int i = 0 ; i < s.length(); i++){
            dp[i][i] = true;
            result = s.substring(i, i+1);
            if(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                result = s.substring(i, i+2);
            }
        }

        // Strings of length 3 and more
        for(int k = 2; k < s.length(); k++){
            for(int i = 0 ; i + k < s.length() ; i++){
                if(s.charAt(i) == s.charAt(i + k) && dp[i+1][i+k-1]){
                    dp[i][i+k] = true;
                    String str = s.substring(i, i+k);
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        new LongestPalindromicSubstring().longestPalindrome("ccc");
    }
}
