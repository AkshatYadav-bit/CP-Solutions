class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int  n = str1.length();
        int m = str2.length();
        int[][] t = new int[n+1][m+1];
        // t[i][j] = length of longest subsequence in i length  of str1 and j length of str2

        for(int i = 1; i < n+1 ; i++){
            for(int j = 1; j < m+1 ; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i][j-1] , t[i-1][j]);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        int i = n;
        int j = m;
        while(i > 0 &&  j >  0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                ans.append(str1.charAt(i-1));
                i--;
                j--;
            }else{
                int a = t[i][j-1];
                int b = t[i-1][j];
                if(a > b){
                    ans.append(str2.charAt(j-1));
                   
                    j--;
                }else{
                    // ans.append(str2.charAt(j-1));
                     ans.append(str1.charAt(i-1));
                    i--;
                }
            }
        }
        while( i >  0){
            ans.append((str1.charAt(--i)));
        }
         while( j >  0){
            ans.append((str2.charAt(--j)));
        }
        return ans.reverse().toString();

    }
}