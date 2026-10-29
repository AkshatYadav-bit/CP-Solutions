class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
       
        String[] srr = sentence.split(" ");
        List<Trie> lst = new ArrayList<>();
        for(String s : srr){
            Trie tr = new Trie();
            tr.insert(s);
            lst.add(tr);
        }
        
        for(String pre : dictionary){
            for(int i = 0; i < lst.size(); i++){
                if(lst.get(i).startsWith(pre) == true){
                    srr[i] = pre;

                    // updating in lst too
                    Trie tr = new Trie();
                    tr.insert(pre);
                    lst.set(i,tr);
                }
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