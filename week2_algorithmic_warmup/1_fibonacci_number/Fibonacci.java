import java.util.Scanner;

public class Fibonacci {
  private static long nlower = 0
  private static long nhigher = 0
  private static void setN(long n) {
    if(nlower < nhigher) nlower = n;
    else nhigher = n;
  }
  private static long setNext() {
      setN(nlower + nhigher)
  }
  private static long getHiger(){ return nlower > nhigher ? nlower : nhigher }

  private static long calc_fib(int n) {
      int i = -1;
      while (++i <= n) setNext();
      return getHiger()

  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
