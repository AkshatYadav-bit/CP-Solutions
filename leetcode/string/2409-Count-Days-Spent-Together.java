class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        //int[] arr = new int[365+1];
        int[] days = new int[]{0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int d = 0;
        for(int i = 1 ;i <= 12 ; i++){
            int t = days[i];
            days[i] = d;
            d +=t;
        }

        int alice_arrive_month = Integer.parseInt(arriveAlice.substring(0,2));
        int alice_arrive_day = Integer.parseInt(arriveAlice.substring(3,5));

        int alice_leave_month = Integer.parseInt(leaveAlice.substring(0,2));
        int alice_leave_day = Integer.parseInt(leaveAlice.substring(3,5));

        int bob_arrive_month = Integer.parseInt(arriveBob.substring(0,2));
        int bob_arrive_day = Integer.parseInt(arriveBob.substring(3,5));

        int bob_leave_month = Integer.parseInt(leaveBob.substring(0,2));
        int bob_leave_day = Integer.parseInt(leaveBob.substring(3,5));

        int s1 = days[alice_arrive_month] + alice_arrive_day;
        int s2 = days[bob_arrive_month] + bob_arrive_day;

        int e1 = days[alice_leave_month]+   alice_leave_day;
        int e2 = days[bob_leave_month]+bob_leave_day;

        // System.out.println(s1+" and "+e1);
        // System.out.println(s2+" and "+e2);

        if(s1 >= s2 && e1 <= e2 ){
            return e1-s1+1;
        }else if(s2 >= s1 && e2 <= e1 ){
            return e2-s2+1;
        }else if(e1 <= e2 && s2 <= e1){
            return e1-s2+1;
        }else if(e2 <= e1 && s1 <= e2){
            return e2-s1+1;
        }
        return 0;
        
    }

   
}