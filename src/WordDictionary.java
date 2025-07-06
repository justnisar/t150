package src;

class TrieNode{
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode(){
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

public class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    private boolean searchHelper(TrieNode root, int start, String word){

        if(start == word.length()){
            return root.isEndOfWord;
        }

        char ch = word.charAt(start);

        if(ch == '.'){
            boolean result = false;
            for(int i = 0 ; i < 26 ; i++){
                if(root.children[i] != null && searchHelper(root.children[i], start + 1, word)){
                    return true;
                }
            }
        }

        if(root.children[ch - 'a'] == null){
            return false;
        }

        return searchHelper(root.children[ch - 'a'], start + 1, word);

    }

    public boolean search(String word) {
        return searchHelper(root, 0, word);
    }
}
