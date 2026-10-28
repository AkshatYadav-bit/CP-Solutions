class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] t = new int[m][n];

        for(int i = 0 ; i < m ;i++){
            t[0][i] = matrix[0][i];
        
        }
        
        for(int i = 1 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if( j == 0){
                    t[i][j] = matrix[i][j] + Math.min(t[i-1][j],t[i-1][j+1]);
                }else if( j == n -1){
                    t[i][j] = matrix[i][j] + Math.min(t[i-1][j],t[i-1][j-1]);
                }else{
                    t[i][j] = matrix[i][j] + Math.min(Math.min(t[i-1][j+1],t[i-1][j-1]),t[i-1][j]);
                }
            }
        }
        // for(int[] arr : t){
        //     System.out.println(Arrays.toString(arr));
        // }
        int min = Integer.MAX_VALUE;

        for(int j = 0 ; j < n ; j++ ){
            min = Math.min(t[m-1][j],min);
        }
        return min
        ;

    }
}