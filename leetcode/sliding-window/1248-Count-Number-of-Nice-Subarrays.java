class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        List<Integer> lst  = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if( nums[i] % 2 != 0) lst.add(i);
        }
        if( k > lst.size()) return 0;
        int ans = 0;
        for(int i = k-1 ; i < lst.size() ; i++){
            int l = 0;
            int r = 0;
            if( i == k - 1 ) l = lst.get(0)+1;
            else l = lst.get(i-k+1) - lst.get(i-k);
            if( i == lst.size()-1) r = n - lst.get(i);
            else r = lst.get(i+1) - lst.get(i);
            ans += l*r;        
        }
        return ans;
        
    }
}