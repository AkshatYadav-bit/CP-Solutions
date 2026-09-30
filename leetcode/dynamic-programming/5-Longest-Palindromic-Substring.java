class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] t = new boolean[n][n];
        t[0][0] = true;
        String ans = "";
        int max = 0;

        // i = start_index and j = end_index
        for(int j = 0; j < n ; j++){
            for(int i = 0 ; i <= j ;i++){
                if(j - i == 0) t[i][j] = true;
                else if(j-i == 1) t[i][j] = s.charAt(i) == s.charAt(j);
                else t[i][j] = (s.charAt(i) == s.charAt(j) ) && ( t[i+1][j-1] );

                if(t[i][j] == true && max < j - i + 1){
                    ans = s.substring(i,j+1);
                    max = j -i +1;
                }
            }
        }
        return ans;
    }
}