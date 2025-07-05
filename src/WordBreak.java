package src;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for(int i = 1 ; i < s.length() + 1 ; i++){

            for(int j = 0 ; j < i ; j++){
                String str = s.substring(j,i);
                if(dp[j] && set.contains(str)){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];

    }

    public static void main(String[] args) {

        new WordBreak().wordBreak("leetcode", Arrays.asList("leet","code"));
    }
}
