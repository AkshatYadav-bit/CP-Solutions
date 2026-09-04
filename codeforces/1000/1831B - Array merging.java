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
            int[] brr = new int[n];
            Map<Integer,Integer> map1 = new HashMap<>();
            Map<Integer,Integer> map2 = new HashMap<>();
            for(int i = 0 ; i < n ; i++){
                arr[i]  = fs.nextInt();
            }
            for(int i = 00 ; i  < n ; i++){
                brr[i] = fs.nextInt();
            }

            int i = 0;
            while (i < n) {
                int count = 0;
                int val = arr[i];
                while (i < n && arr[i] == val) {
                    i++;
                    count++;
                }
                map1.put(val,map1.getOrDefault(val,0));
                count = Math.max(map1.get(val),count);
                map1.put(val,count);
            }

            int ans = 0;
            i = 0;
            while (i < n) {
                int count = 0;
                int val = brr[i];
                while (i < n && brr[i] == val) {
                    i++;
                    count++;
                }
                map2.put(val,map2.getOrDefault(val,0));
                count = Math.max(map2.get(val),count);
                map2.put(val,count);
                ans = Math.max(ans,count);
            }
            // out.append(map1).append('\n');
            // out.append(map2).append('\n');
          
            for(int k : map1.keySet()){
                int v = map1.get(k);
                int sum = v;
                if(map2.containsKey(k)) sum += map2.get(k);
                ans = Math.max(ans,sum);
            }
            out.append(ans).append('\n');

            
        }

        System.out.print(out);
    }
}