class Solution {
    public long maximizeSum(int[] nums, int k) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            int[] x = new int[2];
            x[0] = rearrange(nums[i]) - nums[i];
            x[1] = nums[i];
            arr[i] = x; 
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0],b[0]));
       // for(int[] x : arr) System.out.println(Arrays.toString(x));
        long sum = 0;
        for(int i = n - 1; i >= 0 ; i--){
            int[] x = arr[i];
            int a ;
           if(k > 0 && x[0] != 0){
             a = x[0] + x[1];
             k--;
           }else{
            a = x[1];
           }
           //System.out.println(a);
           sum +=a;
        }
        return sum;
        
    }
    int rearrange(int n){
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        while( n > 0){
            int rem = n  % 10;
            q.offer(rem);
            n = n / 10;
        }
        //System.out.println(q);
        int res = 0;
        while( q.size() > 0){
            res = res*10+q.poll();
        }
        return res;
    }
}