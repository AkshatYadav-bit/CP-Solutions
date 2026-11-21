class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // actual target:- find nodes which are not in cycle

        int n = graph.length;
        int[] vis = new int[n];
        int[] pathvis = new int[n];
        List<Integer> lst = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            if(vis[i] == 0){
                dfs(i,vis,pathvis,graph,lst);
            }
        }
        Collections.sort(lst);
        return lst;
    }
    boolean dfs(int s,int[] vis, int[] pathvis, int[][] graph, List<Integer>lst){
        vis[s] = 1;
        pathvis[s] = 1;

        for(int node : graph[s]){
            if(vis[node] == 0){
                if(dfs(node,vis,pathvis,graph,lst) == true) return true;
            }else if(pathvis[node] == 1) return true;
        }
        pathvis[s] = 0;
        // this "s" node is not in cycle
        lst.add(s);
        return false;
    }
}