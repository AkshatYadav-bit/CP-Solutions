class Solution {
    public int longestOnes(int[] arr, int k) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        int zeros = 0;
        int max = 0;
        while( j < n){
            if(arr[j] == 0) zeros++;
            while(zeros > k){
                if(arr[i] == 0) zeros--;
                i++;
            }
            max = Math.max(max, j - i +1);
            j++;
        }
        return max;
        
    }
}