class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] t = new int[n][n];
        t[0][0] = 0;
        int count = 0;

        // i = start_index and j = end_index
        // t[i][j] = is it palindromic string in range of (i,j) both inclusive
        // t[i][j] = 1 ==> yes
        // t[i][j] = 0 ==> no
        for(int j = 0; j < n ; j++){
            for(int i = 0 ; i <= j ;i++){
                if(j - i == 0) t[i][j] = 1;
                else if(j-i == 1) t[i][j] = (s.charAt(i) == s.charAt(j))?1:0;
                else t[i][j] =  ( (s.charAt(i) == s.charAt(j) ) && t[i+1][j-1]  == 1)? 1: 0;
                count += t[i][j];
            }
        }
        return count;
        
    }
}