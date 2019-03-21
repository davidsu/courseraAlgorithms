import java.util.*;

public class GCD {
  public static int gcd_naive(int a, int b) {
    return a%b == 0 ? b : gcd_naive(b, a%b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_naive(a, b));
  }
}
