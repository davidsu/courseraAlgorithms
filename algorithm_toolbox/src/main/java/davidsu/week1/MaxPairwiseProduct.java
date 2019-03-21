import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long m1 = 0;
    static long m2 = 0;
    static long getM() { return m1 < m2 ? m1 : m2; }
    static void setM(long newM) { 
        if(m1<m2) {
            m1 = newM;
        } else {
            m2 = newM;
        }
    }

    static long getMaxPairwiseProduct(int[] numbers) {
        for(int i : numbers) {
            if(i>getM()) setM(i);
        }

        return m1 * m2;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
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
