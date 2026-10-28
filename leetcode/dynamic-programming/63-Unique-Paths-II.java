class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid[0][0] == 1) return 0;
        int m = grid.length;
        int n  = grid[0].length;
        int[][] t = new int[m][n];
        //t[i][j] = no. of ways to reach i and j

        for(int i  = 0 ; i < m ; i++){
            if(grid[i][0] == 1){
                while(i < m) t[i++][0] = 0;
            }
            else t[i][0] = 1;
        }
        for(int j = 0 ; j < n ; j++){
            if(grid[0][j] == 1){
                while(j < n) t[0][j++] = 0;
            }
            else t[0][j] = 1;
        }


        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n  ; j++){
                if(grid[i][j] == 1) t[i][j] = 0;
                else t[i][j] = t[i-1][j]+t[i][j-1];
            }
        }
        return t[m-1][n-1];
        
    }
}