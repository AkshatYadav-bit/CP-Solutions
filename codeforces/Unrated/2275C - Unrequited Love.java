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
            int[] arr = new int[n+1];
            // Map<Long,Set<Integer>> map = new HashMap<>();
             Map<Long,Long> map = new HashMap<>();
             long[] brr = new long[n+1];
            for(int i = 1; i  <= n ; i++){
                arr[i] = fs.nextInt();
            }
            for(int i = 1; i <= n- 4 ; i++){
                long sum = arr[i]+arr[i+2]-arr[i+4];
                // out.append(sum+" ");
                brr[i] = sum;
                map.put(sum,map.getOrDefault(sum, 0L)+1);
            }
            long ans = 0;
            Map<Long,Long> check = new HashMap<>();
            for(int i = 1; i <= n - 4 ; i++){
               
                long s = brr[i];
                check.put(s,check.getOrDefault(s, 0L)+1);
                if(map.get(s)-check.get(s) > 0){
                    long f = map.get(s)-check.get(s);
                    boolean a =  ((i+2 <= n-4) && brr[i+2] == s);
                    boolean b = ((i+4 <= n-4) && brr[i+4] == s);
                    if( a && b) f -=2;
                    else if(a || b){
                            f -=1;
                    }
                    //out.append(f+" ");
                    ans +=f;
                }
            }
            //out.append('\n');
            //out.append(map).append('\n');
            out.append(ans).append('\n');
            
        }

        System.out.print(out);
    }
}