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
            int x = fs.nextInt();
            int y = fs.nextInt();
            int r = fs.nextInt();

            for(int i = -100; i  <= 100 ; i++){
                boolean found = false;
                for(int j = -100 ; j <= 100 ; j++){
                    int d = (x-i)*(x-i)+(y-j)*(y-j);
                    if( d == r*r){
                        out.append(i+" "+j).append('\n');
                        found = true;
                        break;
                    }
                }
                if(found == true){
                    break;
                }
            }

            
        }

        System.out.print(out);
    }
}