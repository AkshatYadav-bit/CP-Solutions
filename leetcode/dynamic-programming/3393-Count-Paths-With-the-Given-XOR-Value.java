class Solution {
    long mod = (long)(1e9+7);
    public int countPathsWithXorValue(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        long[][][] t = new long[m][n][16];
        
        // t[i][j][v] = no. of paths to reach (i,j) with xor value = v

        t[0][0][grid[0][0]] = 1;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int x = grid[i][j];

                for(int v = 0 ; v < 16 ; v++){
                    if(i == 0 && j == 0) continue;
                    if( i > 0) t[i][j][x^v] += t[i-1][j][v]%mod;
                    if(j > 0) t[i][j][x^v] += t[i][j-1][v]%mod;
                }
            }
        }
        return (int)(t[m-1][n-1][k]%mod);
    }
}