import java.util.*;
import java.math.BigInteger;

public class FibonacciSumLastDigit {
    private static BigInteger ten = new BigInteger("10");
    private static BigInteger recurseFibSum(BigInteger prev, BigInteger cur, BigInteger sum, long count) {
        if(count == 0) return sum;
        return recurseFibSum(cur, prev.add(cur), sum.add(cur).mod(ten), count-1);
    }
    public static BigInteger getFibonacciSumNaive(long n) {
      return recurseFibSum(new BigInteger("0"), new BigInteger("1"), new BigInteger("0"), n%60);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        BigInteger s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

