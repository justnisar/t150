package src;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {

    public void insert(String word, TrieNode root) {
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            int pos = ch - 'a';
            if(current.children[pos] == null){
                current.children[pos] = new TrieNode();
            }
            current = current.children[pos];
        }
        current.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();
        if(board == null || board.length == 0){
            return result;
        }

        // Insert all words in trie
        TrieNode root = new TrieNode();
        for(String word : words){
            insert(word, root);
        }

        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                dfs(i, j, board, root, result);
            }
        }

        return result;
    }

    public void dfs(int i, int j, char[][] board, TrieNode root, List<String> result){
        char ch = board[i][j];
        if(root.children[ch - 'a'] == null){
            return;
        }
        TrieNode currentNode = root.children[ch - 'a'];
        if(currentNode.word != null){
            result.add(currentNode.word);
            currentNode.word = null;
        }
        board[i][j] = '#';
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        for(int[] direction : directions){
            int nextI = i + direction[0];
            int nextJ = j + direction[1];
            if(nextI >= 0 && nextI < board.length && nextJ >= 0 && nextJ < board[0].length && board[nextI][nextJ] != '#'){
                dfs(nextI, nextJ, board, currentNode, result);
            }
        }
        board[i][j] = ch;
    }

    class TrieNode{
        TrieNode[] children;
        String word;

        TrieNode(){
            children = new TrieNode[26];
        }
    }

}