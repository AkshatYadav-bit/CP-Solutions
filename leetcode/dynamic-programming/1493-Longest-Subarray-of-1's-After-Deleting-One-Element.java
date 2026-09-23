class Solution {
    public int longestSubarray(int[] arr) {
        int max =0;
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        int i  = 0;
        int j = 0;
        while ( j < n){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            while(i < n && map.size() > 1 && map.get(0) > 1){
                if(arr[i] == 0) map.put(0,map.get(0)-1);
                if(arr[i] == 1){
                    map.put(1,map.get(1)-1);
                }
                i++;
            }
            if(map.containsKey(1) && map.containsKey(0)) max = Math.max(max,map.get(1));
            else if(map.containsKey(1)) max = Math.max(max,map.get(1)-1);
            j++;
        }
        return max;
        
    }
}