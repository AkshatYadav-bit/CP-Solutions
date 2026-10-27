class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        for(int i = 0 ; i <= m-1 ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j <= n - 1; j++){
                if(m == 1 || n == 1){
                    sb.append('.');
                    continue;
                }
                if((i == 0 && j <= n-2)
                || (i == 1 && j == n-2)
                ||(i >= 1 && j == n-1)
                 ){
                    sb.append('.');
                }else{
                    sb.append('#');
                }
            }
            ans[i] = sb.toString();
        }
        return ans;
        
    }
}