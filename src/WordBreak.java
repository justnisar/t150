package src;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        // start building for each length
        boolean[] table = new boolean[s.length() + 1];
        // string of length 0 is always true, empty string
        table[0] = true;

        // Compute for length of 1 to length of no. of chars in s
        for(int i = 1 ; i < s.length() + 1 ; i++){
            for(int j = 0 ; j <= i ; j++){
                String right = s.substring(j, i);
                if(table[j] && set.contains(right)){
                    table[i] = true;
                    break;
                }
            }
        }
        return table[s.length()];
    }

    public static void main(String[] args) {

        new WordBreak().wordBreak("leetcode", Arrays.asList("leet","code"));
    }
}
