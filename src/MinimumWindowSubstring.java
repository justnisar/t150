package src;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    private int[] recordCounts(String str){
        int[] array = new int[128];
        for(char ch : str.toCharArray()){
            array[ch]++;
        }
        return array;
    }

    public String minWindow(String s, String t) {
        String result = "";
        int min = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int[] array = recordCounts(t);
        int expected = t.length();
        while(end < s.length()){

            char ch = s.charAt(end);
            if(array[ch] > 0){
                expected--;
            }
            array[ch]--;
            // All characters from t have been used
            while(expected == 0){
                int currentWindowSize = end - start + 1;
                if(currentWindowSize < min){
                    min = currentWindowSize;
                    result = s.substring(start, end + 1);
                }
                char removeCh = s.charAt(start);
                start++;
                array[removeCh]++;
                if(array[removeCh] > 0){
                    expected++;
                }
            }

            end++;
        }
        return result;
    }

    public static void main(String[] args) {
        new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC");
    }
}
