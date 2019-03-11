import java.util.Scanner;

public class Fibonacci {
  private static long nlower = 1;
  private static long nhigher = 0;
  private static void setN(long n) {
    if(nlower < nhigher) nlower = n;
    else nhigher = n;
  }
  private static void setNext() {
      setN(nlower + nhigher);
  }
  private static long getHiger(){ return nlower > nhigher ? nlower : nhigher; }

  public static long calc_fib(int n) {
    nlower = 0;
    nhigher = n == 0 ? 0 : 1;
    while (--n > 0) setNext();
    return getHiger();
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
