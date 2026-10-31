class Pair{
    int first; int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}


class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int ans = 0;
        for(int l = 0 ; l < m ; l++){
            for(int r = 0 ; r < n ; r++){
                if(grid[l][r] == '1' && vis[l][r] == 0){
                    ans++;
                    bfs(new Pair(l,r),vis,grid);
                }
            }
        }
        return ans;
    }
    private void bfs(Pair x, int[][] vis, char[][] adj){
        Queue<Pair> q = new LinkedList<>();
        vis[x.first][x.second] = 1;
        q.add(x);
        while( !q.isEmpty()){
            // remove
            Pair rem = q.poll();
            int i = rem.first; int j = rem.second;

            // visit the unvisited neigbours
            Pair[] neighbours = new Pair[]{
                new Pair(i+1,j), new Pair(i-1,j),
                new Pair(i,j-1), new Pair(i,j+1)
            };
            for(Pair nbr : neighbours){
                if(!isValidNeighbour(nbr,adj.length, adj[0].length)) continue;

                // only valid neighbours here
                int l = nbr.first; int r = nbr.second;
                if(adj[l][r] == '1' && vis[l][r] == 0){
                    // if it is neigbour and not visited
                    vis[l][r] = 1;
                    q.add(nbr);
                }
            }
        }
    }

    private boolean isValidNeighbour(Pair p, int m , int n){
        int i = p.first;
        int j = p.second;
        if( 0 <= i && i < m && 0 <= j && j < n) return true;
        return false;
    }
}