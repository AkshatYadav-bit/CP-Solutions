class Solution {
    public int minOperations(int[] arr, int x) {
        int total = 0;
        for(int num : arr){
            total +=num;
        }
        System.out.println(total);
        int t = total - x;
        if(t == 0) return arr.length;
        int n = arr.length;

        int s = 0;
        int i = 0;
        int j = 0;
        int max_l = 0;
        while( j < n){
            s += arr[j];
            while(i < n && s > t){
                s -= arr[i];
                i++;
            }
            if(s == t) {
                max_l = Math.max(max_l,j-i+1);
            }
            j++;
        }
        if(max_l == 0) return -1;
       
        return n - max_l;
        
    }
}