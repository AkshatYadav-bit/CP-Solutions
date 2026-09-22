class Solution {
    public int[] occurrencesOfElement(int[] arr, int[] queries, int x) {
        int[] ans = new int[queries.length];
        List<Integer> lst = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == x)lst.add(i);
        }
        for(int i = 0 ; i < queries.length ; i++){
            int k = queries[i];
            if(k <= lst.size()){
                ans[i] = lst.get(k-1);
            }else{
                ans[i] = -1;
            }
        }
        return ans;
        
    }
}