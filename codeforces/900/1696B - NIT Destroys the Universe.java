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
            // int[] arr = new int[n+1];
            long count = 0;
            long prev = 0;
            // boolean isThisNon_Zeros_Stream_Counted = false;

            for(int i = 1 ; i <= n  ; i++){
                long x = fs.nextLong();
                if(prev == 0 && x != 0){
                    count++;
                }
                prev = x;
            }
            long ans  = (count <= 1)? count:2;
            out.append(ans).append('\n');
            
        }

        System.out.print(out);
    }
}