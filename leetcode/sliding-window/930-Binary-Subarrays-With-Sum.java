class Solution {
    public int numSubarraysWithSum(int[] arr, int k) {
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;
        map.put(0,1);

        for(int  i = 0 ; i < n; i++){
            sum += arr[i];
            // sum - x = k
            // x = sum - k
            if(map.containsKey(sum - k)){
                ans += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);

        }
        return ans;
        
    }
}