class Solution {
    public int minimumEffortPath(int[][] heights) {
        // a simple disjktra algo
        // nodes are the coordinates

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        // int(i,j,d) d = effort of to the route reaching (i,j)
        int n = heights.length;
        int m = heights[0].length;
        int[][] diff = new int[n][m];
        for(int[] drr : diff)  Arrays.fill(drr,(int)(1e9));
        diff[0][0] = 0;
        pq.offer(new int[]{0,0,diff[0][0]});
        int[] deltarow = {-1,0,1,0}; int[] deltacol = {0,1,0,-1};
        while(!pq.isEmpty()){
            int r = pq.peek()[0];
            int c = pq.peek()[1];
            int d = pq.peek()[2];

            pq.poll();

            for(int i = 0 ; i <  4 ;i++){
                int new_r = r + deltarow[i];
                int new_c = c + deltacol[i];
               
                if(new_r >= 0 && new_r < n && new_c >= 0 && new_c < m){
                    int new_effort = Math.max(Math.abs(heights[r][c] - heights[new_r][new_c]),d);
                    if(new_effort < diff[new_r][new_c]){
                        diff[new_r][new_c] = new_effort;
                        pq.offer(new int[]{new_r,new_c,diff[new_r][new_c]});
                    }
                }
            }
           

        }
        //for(int[] a : diff) System.out.println(Arrays.toString(a));
        return diff[n-1][m-1];
    }
}