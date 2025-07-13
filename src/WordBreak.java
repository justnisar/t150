package src;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        // empty string
        dp[0] = true;
        for(int i = 1 ; i < s.length() + 1 ; i++){
            for(int j = 0; j < i ; j++){
                String str = s.substring(j, i);
                if(dp[j] && set.contains(str)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];

    }

    /*
    0 1 2 3 4 5 6 7
    l e e t c o d e

    0 1 2 3 4 5 6 7 8
    t
     */

    public static void main(String[] args) {

        new WordBreak().wordBreak("leetcode", Arrays.asList("leet","code"));
    }
}
