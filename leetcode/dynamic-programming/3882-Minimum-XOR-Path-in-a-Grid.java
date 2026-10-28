class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][][] t = new boolean[m][n][2048];

        // t[i][j][k] --> is it possible (true/false) to reach at (i,j) with xor = k

        // initialization
        t[0][0][grid[0][0]] = true;
        int s = grid[0][0];
        for(int i = 1 ; i < m ; i++){
            int x = grid[i][0];
            s = x ^ s;
            t[i][0][s] = true;
        }
        s = grid[0][0];

        for(int j = 1 ; j < n ; j++){
            int x = grid[0][j];
            s = x ^ s;
            t[0][j][s] = true;
        }

        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                int x = grid[i][j];
                // now look at all possible values of (i-1,j) and (i,j-1)
                for(int k = 0 ; k < 2048 ; k++){
                    if(t[i-1][j][k] || t[i][j-1][k]){
                        t[i][j][x^k] = true; 
                    }
                }
            }
        }

        for(int k = 0 ; k < 2048 ; k++){
            if(t[m-1][n-1][k] == true) return k;
        }
        return -1;
        
    }
}