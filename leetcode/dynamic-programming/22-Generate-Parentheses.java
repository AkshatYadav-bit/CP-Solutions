class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans  = new ArrayList<>();
        StringBuilder sb = new StringBuilder("(");
        fun(sb,ans,2*n);
        return ans;
    }

    void fun(StringBuilder sb, List<String> ans , int count){
        // System.out.println(count+" sb = "+sb.toString());
        if(sb.length() == count ){
            if (isValidParentheses(sb)) ans.add(sb.toString());
            return;
        }

        sb.append('(');
        fun(sb,ans,count);

        sb.deleteCharAt(sb.length()-1);
        sb.append(')');

        fun(sb,ans,count);
        
        sb.deleteCharAt(sb.length()-1);
    }

    boolean isValidParentheses(StringBuilder sb){
        Deque<Character> stk = new ArrayDeque<>();
        for(int i = 0 ; i < sb.length() ; i++){
            char ch = sb.charAt(i);
            if(ch == '(') stk.push('(');
            else{
                if(stk.size() == 0) return false;
                if(stk.peek() == '(') stk.pop();
                else return false;
            }
        }
        return stk.size() == 0;
    }
}