class Solution {
    public boolean isValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();

        for(char x : s.toCharArray()){
            if(x == '(' || x == '[' || x == '{'){
                stk.push(x);
            }else{
                int n = stk.size();
                if(n > 0){
                    if(x == ')' && stk.peek() == '('){
                        if( n > 0) stk.pop();
                    }else if(x == '}' && stk.peek() == '{'){
                        if( n > 0)  stk.pop();
                    }else if(x == ']' && stk.peek() == '['){
                        if( n > 0)  stk.pop();
                    }else{
                        stk.push(x);
                    }
                }else{
                    stk.push(x);
                }
            }
        }
        return stk.size() == 0;
    }
}