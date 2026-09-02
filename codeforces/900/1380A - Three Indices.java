import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
        private final BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        private StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
        char nextChar() throws IOException {
            return next().charAt(0);
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++){
                arr[i] = fs.nextInt();
            }
            int[] pse = prevse(arr);
            int[] nse = nextse(arr);
            int[] ans = new int[3];
            // System.out.println(Arrays.toString(pse));
            //  System.out.println(Arrays.toString(nse));

            for(int i = 0 ;i < n ; i++){
                if(pse[i] != -1 && nse[i] != -1){
                    ans[0] = pse[i];
                    ans[1]= i;
                    ans[2] = nse[i];
                    break;
                }
            }
            if(ans[0] != ans[1] && ans[1] != ans[2] && ans[2] != ans[0]){
                out.append("YES").append('\n');
                out.append((ans[0]+1)+" "+(ans[1]+1)+" "+(ans[2]+1)).append('\n');
            }else{
                out.append("NO").append('\n');
            }


            
        }

        System.out.print(out);
    }
    static int[] prevse(int[] arr){
        int n = arr.length;
        Deque<Integer> s =  new ArrayDeque<>();
        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i] ){
                s.pop();
            }
            ans[i] = (s.isEmpty())?-1:s.peek();
            s.push(i);
        }
        return ans;
    }
    static int[] nextse(int[] arr){
        int n = arr.length;
        Deque<Integer> s =  new ArrayDeque<>();
        int[] ans = new int[n];
        for(int i = n-1 ; i >= 0 ; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i] ){
                s.pop();
            }
            ans[i] = (s.isEmpty())?-1:s.peek();
            s.push(i);
        }
        return ans;
    }
}