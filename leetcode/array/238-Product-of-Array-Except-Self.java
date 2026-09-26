class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        ans[n-1] = 1;
        for(int i = n-2 ; i  >= 0 ; i--){
            ans[i] = ans[i+1]*arr[i+1];
        }

        int p = 1;
        for(int i = 0; i < n ; i++){
            ans[i] = p*ans[i];
            p = p * arr[i];
        }
        return ans;
        
    }
}