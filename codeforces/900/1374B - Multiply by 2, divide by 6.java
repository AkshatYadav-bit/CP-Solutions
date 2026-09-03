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
            long n = fs.nextLong();
            int a = 0; // counts of 6 as factor
            int b = 0; // counts  of 3 as factor
            boolean ans = true;
            while(n > 1){
                if(n%6 == 0){
                    a++;
                    n = n / 6;
                }else if(n%3 == 0){
                    b++;
                    n = n / 3;
                }else{
                    ans  = false;
                    break;
                }
            }
            if(ans){
                out.append(a+b*2).append('\n');
            }else{
                out.append(-1).append('\n');
            }
            
        }

        System.out.print(out);
    }

    static boolean isNumWithoutDigit(double n){
        double n_f = Math.floor(n);
        return (n-n_f) == 0;
    }
}