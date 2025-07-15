package src;
import java.util.*;

public class SubstringWithConcatenationOfAllWords {

    private Map<String, Integer> buildWordFrequencyMap(String[] words){
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Set<String> solutionSet = new HashSet<>();
        if(s == null || s.isEmpty() || words == null || words.length == 0){
            return result;
        }
        Map<String, Integer> map = buildWordFrequencyMap(words);
        int wordLength = words[0].length();
        int windowSize = wordLength * words.length;
        // Look at all the windows
        for(int i = 0 ; i < s.length() - windowSize + 1; i++){
            String windowStr = s.substring(i, i + windowSize);
            if(solutionSet.contains(windowStr)){
                result.add(i);
                continue;
            }
            Map<String, Integer> tempMap = new HashMap<>();
            boolean breakLoop = false;
            for(int j = 0 ; j < words.length ; j++){
                int wordStartIndex = i + j * wordLength;
                String str = s.substring(wordStartIndex, wordStartIndex + wordLength);

                if(!map.containsKey(str)){
                    breakLoop = true;
                    break;
                }
                tempMap.put(str, tempMap.getOrDefault(str, 0) + 1);
            }
            if(!breakLoop && map.equals(tempMap)){
                result.add(i);
                solutionSet.add(windowStr);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        new SubstringWithConcatenationOfAllWords().findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"});
    }
}
