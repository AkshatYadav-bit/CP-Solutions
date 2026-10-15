class Solution {
    public int sumCounts(List<Integer> arr) {
        int ans = 0;
        int n = arr.size();
        for(int i = 0 ; i < n ; i++){
            Map<Integer,Integer> map = new HashMap<>();
            for(int j = i ; j < n ; j++){
                map.put(arr.get(j),map.getOrDefault(arr.get(j),0)+1);
                int  k = map.size();
                ans += k*k;
            }
            map.clear();
        }
        return ans;
    }
}