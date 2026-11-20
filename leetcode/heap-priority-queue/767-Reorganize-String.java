class Solution {
    public String reorganizeString(String s) {
        StringBuilder ans = new StringBuilder();
        int counter = s.length();
        int[] arr = new int[26];
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) ->Integer.compare(b[1],a[1]));
        for(int i = 0 ; i < 26 ; i++){
            if(arr[i] > 0) q.offer(new int[]{i,arr[i]});
        }
        // while(!q.isEmpty()){
        //     System.out.println(Arrays.toString(q.poll()));
        // }

        while(!q.isEmpty()){
            int[] max = q.poll();
            char ch = (char)(max[0]+'a');
            int size = max[1];

            for(int i = 0 ; i < size -1; i++){
                ans.append(ch);
                if(!q.isEmpty()){
                    int[] top = q.poll();
                    char addch = (char)(top[0]+'a');
                    int f = top[1];
                    ans.append(addch);
                    if( f-1 > 0){
                        q.offer(new int[]{top[0],f-1});
                    }
                }else{
                    return "";
                }
            }
            ans.append(ch);
        }

    
        return ans.toString();
        
    }
}