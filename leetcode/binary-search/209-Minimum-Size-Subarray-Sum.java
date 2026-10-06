class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        int j = 0;
        while( j < n){
            sum += arr[j];
            while(sum >= target){
                min = Math.min(min,j-i+1);
                sum -= arr[i];
                i++;
            }
            j++;
        }
        return (min != Integer.MAX_VALUE)?min:0 ;
    }
}