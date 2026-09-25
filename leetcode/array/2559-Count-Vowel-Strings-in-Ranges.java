class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] arr = new int[words.length];
        int n  = arr.length ; 
        for(int i = 0 ; i < n ; i++){
            if(isVowel(words[i]) == true) arr[i] = 1;
            if( i > 0) arr[i] = arr[i]+arr[i-1];
        }
        // System.out.println(Arrays.toString(arr));
        int[] ans = new int[queries.length];
        for(int i = 0 ; i < queries.length ; i++){
            int s = queries[i][0];
            int e = queries[i][1];
            if( s == 0) ans[i] = arr[e];
            else ans[i] = ( arr[s] == arr[s-1])? arr[e]-arr[s]:arr[e]-arr[s-1];
        }
        return ans;
    }

    boolean isVowel(String s){
        char ch = s.charAt(0);
        char chl = s.charAt(s.length()-1);
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            if(chl == 'a' || chl == 'e' || chl == 'i' || chl == 'o' || chl == 'u'){
                return true;
            }
        }
        return false;
    }
}