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
                StringBuilder key = new StringBuilder();
                while(i < n && s.charAt(i) != ')'){
                    // System.out.println("o");
                    key.append(s.charAt(i));
                    i++;
                }
                if(map.containsKey(key.toString())) sb.append(map.get(key.toString()));
                else sb.append("?");
                continue;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}