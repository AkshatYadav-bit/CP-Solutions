class Solution {
    public void solve(char[][] board) {
        
        // we will be using bfs to detect if the region/graph touches touches boundary or not
        int n = board.length;
        int m = board[0].length;
        for(int i = 0 ; i < n ; i++) System.out.println(Arrays.toString(board[i]));
        boolean[][]  vis = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] == 'O' && vis[i][j] == false) {
                    vis[i][j] = true;
                    bfs(i,j,board,vis);
                }
            }
        }
        // System.out.println("####");
        // for(int i = 0 ; i < n ; i++) System.out.println(Arrays.toString(board[i]));
        

    }
    void bfs(int startrow,int startcol,char[][] board,boolean[][] vis){
        List<int[]> lst = new ArrayList<>();
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.addFirst(new int[]{startrow,startcol});
        int n = board.length;
        int m = board[0].length;
    
        boolean isValid = true;
        int[] delrow = {-1,0,1,0}; int[] delcol = {0,1,0,-1};
        while(!q.isEmpty()){
            int r = q.getLast()[0];
            int c = q.getLast()[1];
            lst.add(q.removeLast());

            for(int i = 0 ; i < 4 ; i++){
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){
                    if(board[nrow][ncol] != 'X' && vis[nrow][ncol] == false){
                        vis[nrow][ncol] = true;
                        q.addFirst(new int[]{nrow,ncol});
                    }
                }else{
                    isValid = false;
                }
            }
        }
      
        if(isValid){
            for(int[] a : lst){
                // System.out.println("startrow "+startrow+" and starcol "+startcol);
                board[a[0]][a[1]] = 'X';
            }
        }
    }
}
