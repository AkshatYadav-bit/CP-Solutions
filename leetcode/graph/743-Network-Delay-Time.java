class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0 ; i < n+1 ; i++) adj.add(new ArrayList<>());
        for(int[] arr : times){
            adj.get(arr[0]).add(new int[]{arr[1],arr[2]});
           
        }

         PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        // int[]{node,dist}

        int[] dist = new int[n+1];
        Arrays.fill(dist,(int)(1e9));
        dist[k] = 0;
        pq.offer(new int[]{k,dist[k]});
       
        while(!pq.isEmpty()){
            int node = pq.peek()[0];
            int d = pq.peek()[1];

            pq.poll();

            for(int[] it : adj.get(node)){
                int new_node = it[0];
                int edgWt = it[1];
                if(edgWt + d < dist[new_node]){
                    dist[new_node] = edgWt + d;
                    pq.offer(new int[]{new_node,dist[new_node]});
                }
            }
           

        }
        System.out.println(Arrays.toString(dist));
        int ans = -1;
        for(int i  = 1 ; i < n + 1; i++){
            if(dist[i] == (int)(1e9)) return -1;
            else ans = Math.max(dist[i],ans);
        }
        return ans;
    }
}