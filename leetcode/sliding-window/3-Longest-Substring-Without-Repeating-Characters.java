class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int n = s.length();
        int max  = 0;
        while( j < n){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            while( map.size() != j - i + 1){
                if(map.get(arr[i]) > 1) map.put(arr[i],map.get(arr[i])-1);
                else map.remove(arr[i]);
                i++;
            }
            max = Math.max(map.size(),max);
            j++;
        }
        return max;
        
    }
}