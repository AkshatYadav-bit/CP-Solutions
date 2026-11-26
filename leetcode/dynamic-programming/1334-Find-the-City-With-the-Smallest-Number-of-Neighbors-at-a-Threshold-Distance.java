class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // we(present you and past me) can use disktra because there are no -ve edges
        // but for this example we are using floyd warshall with TC : O(N^3)

        int[][] dist = new int[n][n];
        for(int[] crr : dist) Arrays.fill(crr,(int)1e9);
        for(int i = 0 ; i < n ; i++) dist[i][i] = 0;
        for(int[] x : edges){
            int u = x[0], v = x[1], wt = x[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ;  j < n ; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }

        // now count the no. of cities for each within threshold distance
        // and save the city
        int ans  = -1;
        int minCity = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
           
            int no_of_cities = 0;
            for(int j = 0 ; j  < n ; j++){
                if(dist[i][j] <= distanceThreshold) no_of_cities++;
            }
            //System.out.println("minCity = "+minCity+" and no = "+no_of_cities);
            if(no_of_cities <= minCity){
                minCity = no_of_cities;
                ans = i;
            }
        }
        return ans;
    }
}