class Solution {
    public int lastStoneWeightII(int[] arr) {
        int n = arr.length;
        int total = 0;
        for(int x : arr){
            total +=x;
        }
        boolean[][] t= new boolean[n+1][total+1];

        // t[i][j] = subset sum j from "i" length array exists or not?
      
        for(int i = 0 ; i < n+1 ; i++){
            t[i][0] = true;
        }

        for(int i = 1 ; i < n + 1 ; i++){
            for(int j = 1 ; j < total+1 ; j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j] || t[i-1][j-arr[i-1]];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        // now checking if there exists sum "j" as a subset from "n" length array
        int min = Integer.MAX_VALUE;
        for(int j = 0 ; j < total+1; j++){
            if(t[n][j] == true && total - 2*j >= 0)  min = Math.min(min,total - 2*j);
        }
        if(min == Integer.MAX_VALUE) return 0;
        return min;


    }
}