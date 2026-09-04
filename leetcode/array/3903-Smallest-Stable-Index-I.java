class Solution {
    public int firstStableIndex(int[] arr, int k) {
        int n = arr.length;
        int[] minarr = new int[n];
        int min_elm = Integer.MAX_VALUE;

        for(int i = n-1 ; i > -1  ;i--){
            min_elm = Math.min(min_elm,arr[i]);
            minarr[i] = min_elm;
        }

        int ans = n;
        int max_elm = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ;i++){
            max_elm = Math.max(max_elm,arr[i]);
            int score = max_elm - minarr[i];
            if(score <= k){
                ans = Math.min(ans,i);
            }
        }
        if(ans == n) return -1;
        return ans;
        
    }
}