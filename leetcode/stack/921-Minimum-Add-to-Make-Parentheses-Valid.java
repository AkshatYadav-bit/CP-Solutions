class Solution {
    public int minAddToMakeValid(String s) {
        int a = 0;
        int b = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '(') a++;
            else {
                if(a > 0) a--;
                else b++; 
            }
        }
        return a+b;
    }
}