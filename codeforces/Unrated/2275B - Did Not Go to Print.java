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
            String str = fs.next();
           // out.append("str = "+str+'\n');
            Deque<Integer> s = new ArrayDeque<>();
            int[] arr = new int[str.length()+1];
            int l = 0;
            for(int i  = 1; i <= n ; i++){
                char x = str.charAt(i-1);
                if( x == '1') s.push(i);
                if(x == '2'){
                    if(s.size()  > 0){
                        arr[s.pop()]++;
                    }else{
                        arr[i]++;
                    }
                    l++;
                }
                if( x== '3'){
                    arr[i]++;
                    l++;
                }
            }
            int k = n  - l;
            out.append(k).append('\n');
            if( k != 0){
                for(int i = 1; i <= str.length() ; i++){
                    if(arr[i]== 0) out.append(i+" ");
                }
            }
        
            out.append('\n');
        }

        System.out.print(out);
    }
}