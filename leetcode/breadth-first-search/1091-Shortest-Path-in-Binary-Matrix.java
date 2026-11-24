class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // for(int[] g : grid) System.out.println(Arrays.toString(g));
        // System.out.println("##############");
          PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        // int(i,j,dist)
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        for(int[] drr : dist)  Arrays.fill(drr,(int)(1e9));
        if(grid[0][0] == 1) return -1;
        dist[0][0] = 1;
        pq.offer(new int[]{0,0,dist[0][0]});
        int[] deltarow = {-1,1,0}; int[] deltacol = {-1,1,0};
        while(!pq.isEmpty()){
            int r = pq.peek()[0];
            int c = pq.peek()[1];
            int d = pq.peek()[2];

            pq.poll();

            for(int i = 0 ; i < 3 ;i++){
                for(int j = 0 ; j < 3 ; j++){
                    if( deltarow[i] == 0 && deltacol[j] == 0) continue;
                    int new_r = r + deltarow[i];
                    int new_c = c + deltacol[j];
                
                    if(new_r >= 0 && new_r < n && new_c >= 0 && new_c < m 
                    && grid[new_r][new_c] == 0){
                        
                        if(1 + d < dist[new_r][new_c]){
                            dist[new_r][new_c] = 1 + d;
                            pq.offer(new int[]{new_r,new_c,dist[new_r][new_c]});
                        }
                    }
                }
            }
           

        }
        // for(int[] a : dist) System.out.println(Arrays.toString(a));
        return (dist[n-1][m-1] != (int)(1e9) ) ? dist[n-1][m-1] : -1;
    }
}