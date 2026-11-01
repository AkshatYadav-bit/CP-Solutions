
class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        
        return traverse(0,0,grid,vis,0,0);
    }

    int[] traverse(int i, int j , char[][] grid, int[][] vis,int last_i, int last_j){
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || i >= m || j < 0  || j >= n || vis[i][j] == 1) return new int[]{last_i,last_j};
        vis[i][j] = 1;
        //System.out.println("i = "+i+" and j = "+j+" and grid[i][j] = "+grid[i][j]);
        if(grid[i][j] == 'U') return traverse(i-1,j,grid,vis,i,j);
        else if(grid[i][j] == 'D') return traverse(i+1,j,grid,vis,i,j);
        else if(grid[i][j] == 'L') return traverse(i,j-1,grid,vis,i,j);
        return traverse(i,j+1,grid,vis,i,j);
    }
}