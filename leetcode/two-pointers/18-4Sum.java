class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> final_ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if( i > 0 && arr[i-1] == arr[i]) continue;
            long t = (long)target - arr[i];
            List<List<Integer>> lst = twoSum(arr,i,t);
            final_ans.addAll(lst);
            // System.out.println(final_ans);
        }
        return final_ans;
    }

    List<List<Integer>> twoSum(int[] arr,int a ,long target){
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        for(int i = a + 1 ; i < n ; i++){
            long t = target - arr[i];
            if( i > a + 1 && arr[i] == arr[i-1] ) continue;

            int s = i + 1;
            int e = n - 1;
            while(s < e){
                long sum = arr[s]+ arr[e];
                if ( sum < t){
                    s++;
                }else if( sum > t){
                    e--;
                }else{
                    ans.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{arr[a],arr[i],arr[s],arr[e]})));
                    s++;
                    e--;
                    while(s < e && arr[s] == arr[s-1]) s++;
                    while(s < e && arr[e] == arr[e+1]) e--;
                }
            }
        }
        return ans;
        
    }
}