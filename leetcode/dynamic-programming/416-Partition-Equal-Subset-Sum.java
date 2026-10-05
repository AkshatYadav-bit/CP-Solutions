class Solution {
    public boolean canPartition(int[] arr) {
        int total = 0;
        for(int k : arr){
            total +=k;
        }
        if(total % 2 != 0) return false;
        int  W = total/2;
        int n = arr.length;
        boolean[][] t = new boolean[n+1][W+1];
        t[0][0] = true;
        for(int i = 1 ; i <= n ; i++){
            t[i][0] = true;
        }
        for(int i = 1 ; i <= n ; i++){
            for(int w = 1 ; w <= W ; w++){
                if( arr[i-1]  > w){
                    t[i][w] = t[i-1][w];
                }else{
                    t[i][w] = t[i-1][w] || t[i-1][w-arr[i-1]];
                }
            }
        }
        return t[n][W];
    }
}