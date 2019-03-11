import java.util.*;
import java.math.BigInteger;

public class FibonacciLastDigit {
    private static BigInteger nlower;
    private static BigInteger nhigher;
    private static void setN(BigInteger n) {
      if(nlower.compareTo(nhigher) < 0) nlower = n;
      else nhigher = n;
    }
    private static void setNext() {
        setN(nlower.add(nhigher));
    }
    private static BigInteger getHiger(){ return nlower.compareTo(nhigher) > 0 ? nlower : nhigher; }

    public static BigInteger getFibonacciLastDigitNaive(int n) {
      n = n%60;
      nlower = new BigInteger("0");
      nhigher = new BigInteger(n == 0 ? "0" : "1");
      while (--n > 0) setNext();
      return getHiger().mod(new BigInteger("10"));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getFibonacciLastDigitNaive(n));
    }
}

