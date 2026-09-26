class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        Map<String,String> map = new HashMap<>();
        for(List<String> lst : knowledge){
            map.put(lst.get(0),lst.get(1));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            if( s.charAt(i) == '('){
                // System.out.println("#");
                i++;
                String key = "";
                while(i < n && s.charAt(i) != ')'){
                    // System.out.println("o");
                    key += s.charAt(i);
                    i++;
                }
                if(map.containsKey(key)) sb.append(map.get(key));
                else sb.append("?");
                continue;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}