class Solution {
    public int minimumDeletions(int[] arr) {
        int max_i = -1;
        int max = Integer.MIN_VALUE;
        int min_i = -1;
        int min = Integer.MAX_VALUE;
        int n = arr.length;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] > max ){
                max = arr[i];
                max_i = i;
            }
            if(arr[i] < min){
                min = arr[i];
                min_i = i;
            }
        }
        int ans = Integer.MAX_VALUE;
        if(max_i < min_i){
            int a1 = max_i + 1;
            int a2 = n - min_i;
            int b = n - max_i;
            int c = min_i + 1;
            ans = Math.min(b,c);
            ans = Math.min(ans,a1+a2);
        }else{
            int a1 = min_i + 1;
            int a2 = n - max_i;
            int b = n - min_i;
            int c = max_i + 1;
            ans = Math.min(b,c);
            ans = Math.min(ans,a1+a2);

        }
        return ans;



        
    }
}