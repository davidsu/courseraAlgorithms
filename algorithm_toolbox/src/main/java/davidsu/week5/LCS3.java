import java.util.*;
import java.util.stream.*;

public class LCS3 {

    public static int getSubBestZ(int[][][] mat, int x, int y, int z) {
        return x == 0 ||
            y == 0 ? 0 : mat[x - 1][y - 1][z];
    }
    public static int getSubBestZX(int[][][] mat, int x, int y, int z) {
        return y == 0 ? 0 : mat[x][y - 1][z];
    }

    public static int getSubBestYZ(int[][][] mat, int x, int y, int z) {
        return x == 0 ? 0 : mat[x - 1][y][z];
    }
    public static int getSubBestY(int[][][] mat, int x, int y, int z) {
        return x == 0 ||
            z == 0 ? 0 : mat[x - 1][y][z - 1];
    }


    public static int getSubBestXY(int[][][] mat, int x, int y, int z) {
        return z == 0 ? 0 : mat[x][y][z- 1];
    }
    public static int getSubBestX(int[][][] mat, int x, int y, int z) {
        return y == 0 ||
            z == 0 ? 0 : mat[x][y - 1][z - 1];
    }

    public static int getSubBestAll(int[][][] mat, int x, int y, int z) {
        int maxz = Math.max(getSubBestZ(mat, x, y, z), getSubBestZX(mat, x, y, z));
        int maxy = Math.max(getSubBestY(mat, x, y, z), getSubBestYZ(mat, x, y, z));
        int maxx = Math.max(getSubBestX(mat, x, y, z), getSubBestXY(mat, x, y, z));

        return Math.max(
                getSubBest(mat, x, y, z),
                Math.max(
                    maxz,
                    Math.max(maxy, maxx)
                    )
                );
    }

    public static int getSubBest(int[][][] mat, int x, int y, int z) {
        return x == 0 ||
            y == 0 ||
            z == 0 ? 0 : mat[x-1][y-1][z-1];
    }
    public static int lcs3(int[] a, int[] b, int[] c) {
        int[][][] mat = new int[a.length][b.length][c.length];
        for(int x = 0; x < a.length; x++){
            for(int y = 0; y<b.length; y++) {
                for(int z = 0; z<c.length; z++) {
                    if(a[x] == b[y] && a[x] == c[z]) mat[x][y][z] = 1 + getSubBest(mat, x, y, z);
                    else mat[x][y][z] = getSubBestAll(mat, x, y, z);
                    // System.out.println(Arrays.deepToString(mat));
                }
            }
        }
        return mat[a.length-1][b.length-1][c.length-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

