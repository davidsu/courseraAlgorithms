import java.util.*;

class EditDistance {
  private static int upperNeighbor(int[][] mat, int i, int j) {
      if(j == 0) return i;
    return mat[i][j-1];
  }
  private static int leftNeighbor(int[][] mat, int i,int j) {
    if(i==0) return j;
    return mat[i-1][j];
  }
  private static int diagonalNeighbor(int[][] mat, int i, int j) {
    if(i==0 || j == 0) return i+j;
    return mat[i-1][j-1];
  }
  private static int min(int x, int y, int z) {
    return java.lang.Math.min(x, java.lang.Math.min(y,z));
  }
  private static int getMinNeighborValue(int[][] mat, int i, int j) {
      return min(
              upperNeighbor(mat, i, j),
              leftNeighbor(mat, i, j),
              diagonalNeighbor(mat, i, j)
              );
  }
  private static void print(int[][] mat) {
      for(int[] t: mat) {
          for(int i: t) System.out.print(i + " ");
          System.out.println();
      }
  }
  public static int EditDistance(String s, String t) {
    s = " " + s;
    t = " " + t;
    int[][] mat = new int[s.length()][t.length()];
    for(int i=0; i<s.length(); i++) mat[i][0] = i; 
    for(int i=0; i<t.length(); i++) mat[0][i] = i; 
    for(int i = 1; i< s.length(); i++) {
      for(int j = 1; j<t.length(); j++) {
          int min = getMinNeighborValue(mat, i, j);
          mat[i][j] = s.charAt(i) != t.charAt(j) ? min + 1 : mat[i-1][j-1];
      }
    }
    // print(mat);
    return mat[s.length() -1][t.length()-1];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
