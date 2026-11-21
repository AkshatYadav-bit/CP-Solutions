class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        int[] color = new int[n]; // 0 -> red and 1 -> yello
        Arrays.fill(color,-1);
        for(int i = 0 ; i < n ; i++){
            if(color[i] == -1){
                if(bfs(i,color,graph) == false) return false;
            }
        }
        return true;
    }
    boolean bfs(int n,int[] color, int[][] graph){
        color[n] = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{n,0}); // 0 -> red color
        while(!q.isEmpty()){
            int node = q.getLast()[0];
            int clr = q.getLast()[1];
            int[] rem = q.removeLast();
            //System.out.println(Arrays.toString(rem));
            for(int x : graph[node]){
                int toColor = (clr == 1)?0:1;
                if(color[x] == -1){
                   color[x] = toColor;
                   q.addFirst(new int[]{x,color[x]});
                }else if(color[x] != toColor){
                    return false; // not a bipartite graph
                }
            }
            //for(int[] arr : q) System.out.println(Arrays.toString(arr));
        }
        return true;
    }
}