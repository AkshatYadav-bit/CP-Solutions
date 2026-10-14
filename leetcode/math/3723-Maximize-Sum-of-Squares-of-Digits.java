class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        if(sum > Math.pow(10,num)-1) return "";
        int count = num;
        int temp = sum;
        while(count > 0){
            if(sum <= 9 && sum > 0) sb.append((char)(sum+'0'));
            else if(sum > 9 ) sb.append('9');
            else sb.append('0');
            sum -=9;
            count--;
        }
        int check = 0;
        for(char ch : sb.toString().toCharArray()){
            check +=(ch-'0');
        }
        if(check != temp) return "";
        return sb.toString();
    }
}