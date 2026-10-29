class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder pre = new StringBuilder();
        char[] arr = strs[0].toCharArray();
        int n = arr.length;
        for(int i = 0 ; i < n ; i++){
            char ch = arr[i];

            boolean isValid = true;
            // compare with all other strings
            for(String s : strs){
                if( i > s.length()-1 || s.charAt(i) != ch){
                    isValid = false;
                    break;
                }
            }
            if(isValid == false) break;
            pre.append(ch);
        }
        return pre.toString();
    }
}