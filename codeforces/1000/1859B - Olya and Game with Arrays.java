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
            int[] m = new int[n]; // min arrays
            int[] sm = new int[n]; // sec min arrays
            for(int i = 0; i < n ; i++){
                int min = Integer.MAX_VALUE;
                int sec_min = Integer.MAX_VALUE;
                int mi = fs.nextInt();
                for(int j = 1 ; j <= mi ; j++){
                    int x = fs.nextInt();
                    // out.append("x = "+x).append('\n');
                    if(x < min){
                        sec_min   = min;
                        min = x;
                    }else if( x < sec_min){
                        sec_min = x;
                    }
                }
                m[i] = min;
                sm[i] = sec_min;
            }
            Arrays.sort(m);
            Arrays.sort(sm);
            
            long sum = Math.min(m[0],sm[0]);
            for(int i = 1 ; i < n  ; i++){
                sum +=sm[i];
            }
            out.append(sum).append('\n');
            
        }

        System.out.print(out);
    }
}