package src;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        Map<Character,Integer> map = new HashMap<>();
        int result = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if(map.containsKey(ch) && map.get(ch) >= start){
                start = map.get(ch) + 1;
            }

            result = Math.max(result, i - start + 1);
            map.put(ch, i);

        }

        return result;
    }

    public static void main(String[] args) {
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb");
    }
}
