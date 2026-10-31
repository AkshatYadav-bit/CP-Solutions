class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] vis = new int[n]; // zero-based indexing
        int ans = 0;
        for(int x = 0 ; x < n ; x++){
            if( vis[x] == 0){
                ans++;
                bfs(x,vis, isConnected); // O(V*V) where V is total no. of nodes
            }
        }
        // O(V^3) is TC
        return ans;
    }

    private void bfs(int x, int[] vis, int[][] adj){
        Queue<Integer> q = new LinkedList<>();
        vis[x] = 1;
        q.add(x);
        while( !q.isEmpty()){
            // remove
            int rem = q.poll();

            // process
            //System.out.println(rem);

            // visit the unvisited neigbours
            int[] neighbours = adj[rem];
            for(int i = 0 ; i < neighbours.length ; i++){
                if(neighbours[i] == 1 && vis[i] == 0){
                    // if it is neigbour and not visited
                    vis[i] = 1;
                    q.add(i);
                }
            }
        }
    }
}