class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        int count = num;
        int temp = sum;
        int check = 0;
        while(count > 0){
            char ch;
            if(sum <= 9 && sum > 0) ch = (char)(sum+'0');
            else if(sum > 9 ) ch = '9';
            else ch = '0';
            check +=(ch-'0');
            sb.append(ch);
            sum -=9;
            count--;
        }
  
        if(check != temp) return "";
        return sb.toString();
    }
}