package src;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> s_map = new HashMap<>();
        Map<Character, Character> t_map = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++) {

            char s_ch = s.charAt(i);
            char t_ch = t.charAt(i);
            if((s_map.containsKey(s_ch) && s_map.get(s_ch) != t_ch) || (t_map.containsKey(t_ch) && t_map.get(t_ch) != s_ch)) {
                return false;
            }
            else{
                s_map.put(s_ch, t_ch);
                t_map.put(t_ch, s_ch);
            }
        }
        return true;
    }
}
