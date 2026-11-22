class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int  n = nums1.length;
        int m = nums2.length;
        int[][] t = new int[n+1][m+1];
        // t[i][j] = length of longest subsequence in i length  of str1 and j length of str2

        for(int i = 1; i < n+1 ; i++){
            for(int j = 1; j < m+1 ; j++){
                if(nums1[i-1] == nums2[j-1]){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i][j-1] , t[i-1][j]);
                }
            }
        }
        return t[n][m];
    }
}