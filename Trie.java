class TrieNode{
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode(){
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

public class Trie  {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            int pos = ch - 'a';
            if(current.children[pos] == null){
                current.children[pos] = new TrieNode();
            }
            current = current.children[pos];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            int pos = ch - 'a';
            if(current.children[pos] == null){
                return false;
            }
            current = current.children[pos];
        }
        if(current.isEndOfWord){
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(char ch : prefix.toCharArray()) {
            int pos = ch - 'a';
            if (current.children[pos] == null) {
                return false;
            }
            current = current.children[pos];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        //obj.insert("nisar");
        //boolean param_2 = obj.search(word);
        //boolean param_3 = obj.startsWith(prefix);
    }
}
