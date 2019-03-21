import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    private static int[] partition3(int[] a, int l, int r) {
      int m1 = l;
      int m2 = r;
      int middleidx = l;
      int x = a[middleidx];

      // System.out.println("middle = " + x);
      for(int i = l + 1; i<=m2 ;) {
          // for(int q: a) System.out.print(q+" ");
          // System.out.println("#############################");
          if(a[i] == x) {
              swap(a, i, middleidx);
              middleidx++;
              i++;
          }else if(a[i] < x) {
              swap(a, i, m1);
              middleidx++;
              m1++;
              i++;
          } else {
              swap(a, i, m2);
              m2--;
          }
      }
      int[] m = {m1, m2};
      return m;
    }

    public static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int[] m = partition3(a, l, r);
        int ml = m[0];
        int mr = m[1];
        // System.out.println(ml + " " + mr);
        randomizedQuickSort(a, l, ml - 1);
        randomizedQuickSort(a, mr + 1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
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

