class Solution {
    public int minAddToMakeValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '(') stk.push(ch);
            else {
                if(stk.size() > 0 && stk.peek() == '(') stk.pop();
                else stk.push(')'); 
            }
        }
        return stk.size();
    }
}