class Solution {
    public int sumOfSquares(int[] arr) {
        int n = arr.length;
        int s = 0;
        int i = 0;
        while(i < n){
            if( n % (i+1) == 0 ) s += arr[i]*arr[i];
            i++;
        }
        return s;
        
    }
}