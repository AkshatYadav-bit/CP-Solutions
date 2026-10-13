class Solution {
    public long maxAlternatingSum(int[] arr) {
        int n = arr.length;
        for(int i = 0 ; i < n ; i++){
            arr[i] = Math.abs(arr[i]);
        }
        Arrays.sort(arr);
        long sum = 0;
        for(int i = n - 1 ; i >=  0 ;i--){
            if(i >= n/2) sum += arr[i]*arr[i];
            else sum -= arr[i]*arr[i];
        }
        return sum;
    }
}