class Solution {
    public int lastStoneWeight(int[] arr) {
        int n  = arr.length;
        if(n == 1) return arr[0];
        int max = 0;
        int sec_max = 1;
        int count = n;

        while(count != 1 &&  count != 0){
            for(int j = 0 ; j < n ; j++){
                if(arr[j] == 0) continue; 
                if(arr[max] < arr[j]){
                    //System.out.println("#");
                    sec_max = max;
                    max = j;
                }else if(arr[sec_max] < arr[j] && j != max){
                    //System.out.println("* "+sec_max+" val = "+arr[sec_max]);
                    sec_max = j;
                }
            }
           // if(arr[sec_max] == -1) return arr[max];
            
            if(arr[max] == arr[sec_max]){
                arr[max] = 0;
                arr[sec_max] = 0;
                count -=2;
            }else{
                arr[max] = arr[max]- arr[sec_max];
                arr[sec_max] = 0;
                count -=1;
               
            }
            //System.out.println("sec_max = "+sec_max+" and max = "+max);
            //System.out.println(Arrays.toString(arr));
        }
        int ans = 0;
        for(int x : arr){
            ans = Math.max(ans,x);
        }
        return ans;
        
    }
}