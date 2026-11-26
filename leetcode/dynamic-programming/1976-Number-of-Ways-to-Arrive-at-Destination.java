class Solution {
    static int mod = (int)(1e9+7);
    public int countPaths(int n, int[][] roads) {
        List<List<long[]>> adj = new ArrayList<>();
        for(int i = 0 ; i < n  ; i++) adj.add(new ArrayList<>());

        for(int[] x : roads){
            adj.get(x[0]).add(new long[]{x[1],x[2]});
            adj.get(x[1]).add(new long[]{x[0],x[2]});
        }

        long[] dist  = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        int[] ways = new int[n];
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[1],b[1]));
        // (node,dist) -> element in pq
        pq.offer(new long[]{0,0});

        while(!pq.isEmpty()){
            int node = (int) pq.peek()[0];
            long d = pq.peek()[1];
            pq.poll();

            for(long[] it : adj.get(node)){
                int new_node =(int) it[0];
                long ed_wt = it[1];

                if(d + ed_wt< dist[new_node]){
                    dist[new_node] = d + ed_wt;
                    pq.offer(new long[]{new_node,dist[new_node]});
                    ways[new_node] = ways[node];
                }else if(d + ed_wt == dist[new_node]){
                    ways[new_node] = (ways[new_node]+ ways[node])%mod;
                }
            }
        }
        // System.out.println(Arrays.toString(dist));
        // System.out.println(Arrays.toString(ways));
        return ways[n-1]%mod;
    }
}