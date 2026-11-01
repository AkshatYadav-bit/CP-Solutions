class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] arr = Arrays.stream(grid).map(x -> Arrays.copyOf(x,x.length)).toArray(int[][]::new);
        int min = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 2){
                    vis[i][j] = 1;
                    q.add(new int[]{i,j});
                }
            }
        }
        int ans  = bfs(0,0,arr,vis,q);
        for(int i = 0 ; i < n ; i++ ){
            for(int j = 0 ; j < m ; j++){
                if(arr[i][j] == 1) return -1;
            }
        }
        return ans;
    }

    int bfs(int r, int c,int[][] arr,int[][] vis,Queue<int[]> q){
        if(q.isEmpty()) return 0;
        int res = -1;
        int n = arr.length; 
        int m = arr[0].length;
       
        while(!q.isEmpty()){
            int level = q.size();

            // visiting all node at this level
            for(int k = 0 ; k < level ; k++){
                    int i = q.peek()[0];
                    int j = q.peek()[1];
                    q.poll();

                    // marking the neighbours as visited and  adding them in queue
                    int[][] delta = new int[][]{new int[]{1,0}, new int[]{-1,0}
                                    ,new int[]{0,1}, new int[]{0,-1}};
                    for(int[] d : delta){
                        int new_i = i + d[0];
                        int new_j = j + d[1];
                        if(new_i >= 0 && new_i < n && new_j >= 0 && new_j < m
                        && arr[new_i][new_j] == 1 && vis[new_i][new_j] == 0){
                            vis[new_i][new_j] = 1;
                            arr[new_i][new_j] = 2;
                            q.add(new int[]{new_i,new_j});
                        }
                    }
            }
            res++;
        }
        return res;
    }
}