import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    Map<Character,Integer> romanToIntMap;

    private void populateRomanToIntMap(){
        romanToIntMap = new HashMap<>();
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);
    }

    private int recFun(int start, int end, char[] strArr){
        if(start == end){
            return romanToIntMap.get(strArr[start]);
        }
        else if(romanToIntMap.get(strArr[start]) >= romanToIntMap.get(strArr[start + 1])){
            return romanToIntMap.get(strArr[start]) + recFun(start + 1, end, strArr);
        }
        return recFun(start + 1, end, strArr) - romanToIntMap.get(strArr[start]);
    }

    public int romanToInt(String s) {
        populateRomanToIntMap();
        return recFun(0, s.length() - 1, s.toCharArray());
    }

    public static void main(String[] args) {
        new RomanToInteger().romanToInt("III");
    }
}
