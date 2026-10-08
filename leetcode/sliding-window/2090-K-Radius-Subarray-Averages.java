class Solution {
    public int[] getAverages(int[] arr, int k) {
        int n = arr.length;
        List<Integer> lst = new ArrayList<>();
        long sum  = 0;
        if(2*k < n){
            for(int i = 00 ; i <= 2*k; i++){
                if(i < k ) lst.add(-1);
                sum += arr[i];
            }
            long avg = sum/(2*k+1);
            lst.add((int)avg);
        }else{
            int[] ans = new int[n];
            for(int i = 0; i < n ; i++) ans[i] = -1;
            return ans;
        }
        
        for(int i = k+1 ; i < n-k ; i++){
            sum += arr[i+k];
            sum -= arr[i-k-1];
            long avg = sum/(2*k+1);
            lst.add((int)avg);
        }
        for(int i = n - k ; i < n ;i++){
            lst.add(-1);
        }
       // System.out.println(lst);
        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++){
            ans[i] = lst.get(i);
        }
        return ans;
        
    }
}