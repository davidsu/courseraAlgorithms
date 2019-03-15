import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class BinarySearch {

    static int binarySearch(int[] a, int val, int sidx, int bidx) {
        if(bidx < sidx) return -1;
        int curidx = (sidx + bidx) / 2;
        if(a[curidx] == val) return curidx;
        if(val < a[curidx]) return binarySearch(a, val, sidx, curidx - 1);
        return binarySearch(a, val, curidx + 1, bidx);
    }
    static int binarySearch(int[] a, int x) {
        return binarySearch(a, x, 0, a.length -1);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        String res = "";
        for (int i = 0; i < m; i++) {
            res += binarySearch(a, b[i]) + " ";
            //replace with the call to binarySearch when implemented
        }
        System.out.print(res);
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
