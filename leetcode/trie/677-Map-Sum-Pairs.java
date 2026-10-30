class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
    int sum = 0;
}
class MapSum {
    Map<String,Integer> map;
    Trie t ;

    public MapSum() {
       map = new HashMap<>();
        t = new Trie();
    }
    
    public void insert(String key, int val) {
        t.insert(key,val,map);
        map.put(key,val);
    }
    
    public int sum(String prefix) {
        return t.sumUpto(prefix);
    }
}

class Trie{
    TrieNode root = new TrieNode();
    void insert(String word,int v, Map<String,Integer> map){
        TrieNode current = root;
       // System.out.println("#");
       
        int toBeRemovedVal = 0;
          if(map.containsKey(word)){
            toBeRemovedVal = map.get(word);
          }
        for(char ch : word.toCharArray()){
            int i = ch - 'a';
            if(current.children[i] == null) current.children[i] = new TrieNode();

            current.children[i].sum += v - toBeRemovedVal;

          //  System.out.println(" sum = "+current.children[i].sum);
            current = current.children[i];
        }
        current.isEnd = true;
    }
    int sumUpto(String pre){
        int ans = 0;
        TrieNode current = root;
        for(char ch : pre.toCharArray()){
            int i = ch - 'a';
            if(current.children[i] == null) return 0;
            //ans += cuurent.children[i].sum;
            current = current.children[i];
        }
        return current.sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */