import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    private String getSortedString(String str){
        char[] strArr = str.toCharArray();
        Arrays.sort(strArr);
        return new String(strArr);
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            String key = getSortedString(str);

            if(map.containsKey(key)){
                map.get(key).add(str);
            }
            else{
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(key, temp);
            }

        }

        for(Map.Entry<String, List<String>> entry : map.entrySet()){

            result.add(entry.getValue());

        }

        return result;
    }
}
