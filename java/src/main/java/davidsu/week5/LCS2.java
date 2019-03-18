import java.util.*;

public class LCS2 {
    public static int lcs2(int[] a, int[] b, int alast, int blast) {
        if(alast == -1 || blast == -1) return 0;
        if(a[alast] == b[blast]) return 1+lcs2(a, b, alast -1, blast - 1);
        return Math.max(lcs2(a,b,alast -1, blast), lcs2(a,b,alast, blast-1));
    }
    public static int getDiagonal(int[][] mat, int i, int j){
        return i == 0 || j == 0 ? 0 : mat[i-1][j-1];
    }
    public static int getLeft(int[][] mat, int i, int j) {
        return i == 0 ? 0 : mat[i-1][j];
    }
    public static int getUp(int[][] mat, int i, int j){
        return j == 0 ? 0 : mat[i][j-1];
    }
    public static int lcs2(int[] a, int[] b) {
        int[][] mat = new int[a.length][b.length];
        for(int i = 0; i<a.length; i++) {
            for(int j = 0; j<b.length; j++) {
                if(a[i] == b[j]) mat[i][j] = 1 + getDiagonal(mat, i, j);
                else mat[i][j] = Math.max(
                        getDiagonal(mat, i, j),
                        Math.max(
                            getLeft(mat, i, j),
                            getUp(mat, i, j)
                            )
                        );
            }
        }
        return mat[a.length-1][b.length-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

        System.out.println(lcs2(a, b));
    }
}

