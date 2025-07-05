package src;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return 0;
    }

    public static void main(String[] args) {
        String[] wordList = {"hot","dot","dog","lot","log"};
        String beginWord = "hit";
        String endWord = "cog";
        new WordLadder().ladderLength(beginWord, endWord, Arrays.asList(wordList));
    }
}
