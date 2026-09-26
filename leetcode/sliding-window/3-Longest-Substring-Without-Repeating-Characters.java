class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        int i = 0 ; 
        int j = 0;
        int max = 0;
        while( j < n){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            // System.out.println(" j = "+j);
            // System.out.println(map);
            while(map.get(arr[j]) > 1){
                // System.out.println("# arr[j] = "+arr[j]);
                if(map.get(arr[i]) > 1) map.put(arr[i],map.get(arr[i])-1);
                else map.remove(arr[i]);
                i++;
            }
            max = Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}