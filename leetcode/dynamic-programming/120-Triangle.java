class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] t = new int[n];
        t[0] = triangle.get(0).get(0);

        for(int i = 1 ; i < n  ; i++){
            int m =  triangle.get(i).size();
            int prev = Integer.MIN_VALUE; // supplementary for t[j-1]
            for(int j = 0 ; j < m; j++){
                int temp = t[j];
                if(j == 0) t[j] = triangle.get(i).get(j)+t[j];
                else if(j == m - 1) t[j] = triangle.get(i).get(j) + prev ;
                else{
                    t[j] =  triangle.get(i).get(j)+ Math.min(t[j],prev);
                }
                prev = temp; // useful for next iteration 
            }
        }
        int min = Integer.MAX_VALUE;
        for(int x : t){
            min = Math.min(x,min);
        }
        return min;
    }
}