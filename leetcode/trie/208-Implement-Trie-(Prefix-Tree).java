class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}
class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;

        for(char ch : word.toCharArray()){
            int i = ch-'a';
            
            // now check if current node has this children at i
            if(current.children[i] == null){
                // if it does not have any child, so create it and assign its reference
                current.children[i] = new TrieNode();
            }

            // move current forward to next child node
            current = current.children[i];
        }
        current.isEnd = true; // word ends here
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            int i = ch-'a';
            if(current.children[i] == null) return false;
            current = current.children[i];
        }
        return current.isEnd == true;
        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(char ch : prefix.toCharArray()){
            int i = ch-'a';
            if(current.children[i] == null) return false;
            current = current.children[i];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */