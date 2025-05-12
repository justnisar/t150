package src;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> characterMap = new HashMap<>();
        Map<String, Character> stringMap = new HashMap<>();
        String[] sArr = s.split(" ");
        if(pattern.length() != sArr.length){
            return false;
        }
        for(int i = 0 ; i < sArr.length ; i++){
            char ch = pattern.charAt(i);
            String str = sArr[i];
            if(!characterMap.containsKey(ch) && !stringMap.containsKey(str)){
                characterMap.put(ch, str);
                stringMap.put(str, ch);
            }
            else if(characterMap.containsKey(ch) && !stringMap.containsKey(str)){
                return false;
            }
            else if(!characterMap.containsKey(ch) && stringMap.containsKey(str)){
                return false;
            }
            if(!characterMap.get(ch).equals(str) || stringMap.get(str) != ch){
                return false;
            }
        }
        return true;
    }

}
