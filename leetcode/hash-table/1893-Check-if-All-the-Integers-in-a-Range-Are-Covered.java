class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] pre = new int[right+1];
        for(int i = 0 ; i < ranges.length ; i++){
            int s = ranges[i][0];
            int e = ranges[i][1]+1;
            if(s < pre.length) pre[s] +=1;
            if( e < pre.length ) pre[e] -=1;
        }
        for(int i = 1 ; i < pre.length ; i++){
            pre[i] += pre[i-1];
        }
        for(int i = left ; i <= right ; i++){
            if(pre[i] == 0) return false;
        }
        return true;
    }
}