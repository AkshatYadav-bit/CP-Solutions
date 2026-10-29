class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
       
        String[] srr = sentence.split(" ");
        Trie t = new Trie();
        for(String s : dictionary){
           t.insert(s);
        }
        
        for(int i = 0; i < srr.length; i++){
            String pre = t.shortestPrefix(srr[i]);
            if(pre.length() != 0){
                srr[i] = pre;
            }
        }

        String ans = Arrays.stream(srr).collect(Collectors.joining(" "));
        return ans;
    }
}

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
    
    public String shortestPrefix(String word){
        StringBuilder ans = new StringBuilder();
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            int i = ch - 'a';

            if(current.children[i] == null){
                // it means this is it
                return "";
            }
            ans.append(ch);
            if(current.children[i].isEnd == true) return ans.toString();

            current = current.children[i];
        }
        return "";
    }
    
    // public boolean search(String word) {
    //     TrieNode current = root;
    //     for(char ch : word.toCharArray()){
    //         int i = ch-'a';
    //         if(current.children[i] == null) return false;
    //         current = current.children[i];
    //     }
    //     return current.isEnd == true;
        
    // }
    
    // public boolean startsWith(String prefix) {
    //     TrieNode current = root;
    //     for(char ch : prefix.toCharArray()){
    //         int i = ch-'a';
    //         if(current.children[i] == null) return false;
    //         current = current.children[i];
    //     }
    //     return true;
    // }
}