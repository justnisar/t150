import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LetterCombinationsOfAPhoneNumber {

    private List<String> result;
    private Map<Character, String> map;

    private Map<Character, String> getCharacterMap(){
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }

    private List<String> recFun(int start, int end, List<String> result, String digits){
        // base case
        if(start == end){
            return result;
        }

        char current = digits.charAt(start);
        String currentString = map.get(current);
        List<String> temp2 = new ArrayList<>();
        for(String temp1 : result){

            for(char ch : currentString.toCharArray()){
                String str = "";
                str += temp1 + ch;
                temp2.add(str);
            }
        }
        return recFun(start+1, end, temp2, digits);

    }

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if(digits.length() == 0){
            return result;
        }
        Map<Character, String> map = getCharacterMap();
        result.addAll(Arrays.stream(map.get(digits.charAt(0)).split("")).map(String::valueOf).toList());
        return recFun(1, digits.length(), result, digits);
    }

    public static void main(String[] args) {
        new LetterCombinationsOfAPhoneNumber().letterCombinations("23");
    }

}
