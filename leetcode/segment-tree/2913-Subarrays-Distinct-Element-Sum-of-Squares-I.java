class Solution {
    public int sumCounts(List<Integer> lst) {
        int ans = 0;
        int n = lst.size();
        for(int i = 0 ; i < n ; i++){
            int[] freq = new int[101];
            int count = 0;
            for(int j = i ; j < n ; j++){
                if(freq[lst.get(j)] == 0){
                    freq[lst.get(j)]++;
                    count++;
                }
                int  k = count;
                ans += k*k;
            }
            Arrays.fill(freq,0);
        }
        return ans;
    }
}