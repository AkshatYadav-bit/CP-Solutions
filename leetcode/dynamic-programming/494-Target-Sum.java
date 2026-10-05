class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        target = Math.abs(target);
        int total = 0;
        for(int x : arr){
            total += x;
        }
        if( (total + target) % 2 != 0 || target > total ) return 0;
        int W = (total + target)/2;
        int n = arr.length;
        int[][] t = new int[n+1][W+1];

        t[0][0] = 1;
        for(int i = 1 ; i <= n ; i++){
            for(int w = 0 ; w <= W ; w++){
                if(arr[i-1] > w){
                    t[i][w] = t[i-1][w];
                }else{
                    t[i][w] = t[i-1][w] + t[i-1][w- arr[i-1]];
                }
            }
        }
        
        return t[n][W];
        
    }
}