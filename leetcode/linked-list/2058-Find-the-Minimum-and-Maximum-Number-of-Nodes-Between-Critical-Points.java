/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode temp = head.next;
        ListNode prev = head;
        List<Integer> lst = new ArrayList<>();
        int count = 2;
        while(temp.next != null){
            int a = temp.next.val;
            int x = temp.val;
            int b = prev.val;
            if( (a < x && x > b) || ( a > x && x < b) ){
                lst.add(count);
            }
            prev = temp;
            temp = temp.next;
            count++;
        }
        //System.out.println(lst);
        //Collections.sort(lst);
        if(lst.size() < 2) return new int[]{-1,-1};
        int max = lst.getLast() - lst.get(0);
        int min = max;
        for(int i = 1 ; i < lst.size() ; i++){
            min = Math.min(lst.get(i) - lst.get(i-1),min);
        }
        return new int[]{min,max};
        
    }
}