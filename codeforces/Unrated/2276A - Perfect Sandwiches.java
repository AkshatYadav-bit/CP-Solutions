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
            int a = fs.nextInt();
            int b = fs.nextInt();
            // a  > b
            int ans = 0;
            
            if(a <= b ){
                out.append(-1);
            }else{
                while (a > b && b > 0 && a > 0) {
                    a -=2;
                    b -=1;
                    ans++;
                }
                out.append(ans);
            }
            out.append('\n');

            
        }

        System.out.print(out);
    }

    // static int gcd(int a, int b){
    //     while(b != 0){
    //         int r = b;
    //         b = a % b;
    //         a = r;
    //     }
    //     return a;
    // }

}