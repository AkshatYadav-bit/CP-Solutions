class Solution {
    public int maxDepth(String s) {
        int a = 0;
        int max = 0;
        for(int x : s.toCharArray()){
            if(x == '(') a++;
            if(x == ')') a--;
            max = Math.max(a,max);
        }
        return max;
        
    }
}