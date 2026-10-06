class Solution {
    public int maxSatisfied(int[] c, int[] g, int k) {
        int n = c.length;
        int[] arr = new int[n];
        int[] brr = new int[n];
        int temp2 = 0;
        int temp = 0;
        for(int i = n - 1; i >= 0 ; i--){
            if(g[i] == 0){
                temp += c[i];
            }
            arr[i] = temp;

            if(g[n-i-1] == 0){
                temp2 += c[n-i-1];      
            }
            brr[n-i-1] = temp2;
        }
        int sum = 0;
        int extra = 0;
        for(int i = 0; i < k ; i++){
            sum += c[i];
        }
        if( k < n) extra += arr[k];
        int max = sum+extra;

        temp = 0;

        for(int i = k ; i  < n ; i++){
            extra = 0;
            sum += c[i];
            sum -= c[i-k];

            //now taking i+1 and i-k into consideration too
            if(i+1 < n) extra += arr[i+1];
            extra += brr[i-k];
            max = Math.max(max,extra+sum);
        }
        return max;
    }
}