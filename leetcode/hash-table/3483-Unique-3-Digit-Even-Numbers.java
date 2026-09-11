class Solution {
    public int totalNumbers(int[] arr) {

        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0  ; i  < n ; i++){
            for(int j = 0 ; j < n ; j++){
               for(int k = 0 ; k < n ; k++){
                if(i != j && j != k && i != k && arr[i] != 0 ){
                    int num = arr[i]*100+arr[j]*10+arr[k];
                    if(num%2 == 0) set.add(num);
                }
               }
            }
        }
        return set.size();
        
    }
}