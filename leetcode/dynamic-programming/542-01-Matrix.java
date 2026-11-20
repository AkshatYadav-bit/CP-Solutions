class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dist = new int[n][m];
        int[][] vis = new int[n][m]; // 0-> univisited and 1 -> visited

        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m  ; j++){
                if(mat[i][j] == 0 && vis[i][j] == 0){
                    vis[i][j] = 1;
                    q.addLast(new int[]{i,j});
                }

            }
        }
        int[] delrow = new int[]{1,0,-1,0};
        int[] delcol = new int[]{0,1,0,-1};
        int level = 1;
        while(!q.isEmpty()){
           int size = q.size();
           for(int k = 0 ; k < size ; k++){
                int r = q.getFirst()[0];
                int c = q.getFirst()[1];
                q.removeFirst();
            
                for(int i = 0 ; i < 4 ; i++){
                    int nrow = r + delrow[i];
                    int ncol = c + delcol[i];

                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && mat[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                            vis[nrow][ncol] = 1;
                            dist[nrow][ncol] = level;
                            q.addLast(new int[]{nrow,ncol});
                    }
                }
           }
           level++;
        }
        return dist;

    }
}