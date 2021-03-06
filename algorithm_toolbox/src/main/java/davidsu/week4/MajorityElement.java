import java.util.*;
import java.io.*;

public class MajorityElement {
    public static int getMajorityElement(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int majority = a.length/2;
        for(int i: a) {
            Integer cur = map.get(i);
            cur = cur == null ? 1 : cur + 1;
            if(cur > majority) return 1;
            map.put(i, cur);
        }
        return -1;

    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
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

