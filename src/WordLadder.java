package src;

import java.util.*;

public class WordLadder {

    private boolean doDifferByOneChar(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        int diffCount = 0;
        for(int i = 0 ; i < str1.length() ; i++){
            if(str1.charAt(i) != str2.charAt(i)){
                diffCount++;
            }
            if(diffCount == 2){
                return false;
            }
        }
        return diffCount == 1;
    }

    private List<String> wordsWithOneCharDiff(String source, List<String> wordList){
        List<String> result = new ArrayList<>();
        for(String str: wordList){
            if(doDifferByOneChar(source, str)){
                result.add(str);
            }
        }
        return result;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int level = 1;

        while(!queue.isEmpty()){

            int levelSize = queue.size();

            for(int i = 0 ; i < levelSize ; i++){
                String current = queue.remove();
                if(current.equals(endWord)){
                    return level;
                }

                List<String> oneCharDiffList = wordsWithOneCharDiff(current, wordList);
                for(String str : oneCharDiffList){

                    if(!visited.contains(str)){
                        visited.add(str);
                        queue.add(str);
                    }

                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] wordList = {"hot","dot","dog","lot","log"};
        String beginWord = "hit";
        String endWord = "cog";
        new WordLadder().ladderLength(beginWord, endWord, Arrays.asList(wordList));
    }
}
