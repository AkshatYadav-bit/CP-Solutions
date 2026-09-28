class Solution {
    public int maxDepth(String s) {
        Deque<Integer> stk = new ArrayDeque<>();

        // int a = 0;
        int max = 0;
        for(int x : s.toCharArray()){
            if(x == '(') stk.push(x);
            if(x == ')') stk.pop();
            max = Math.max(stk.size(),max);
        }
        return max;
        
    }
}