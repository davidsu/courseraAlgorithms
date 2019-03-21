import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class FibonacciTest 
{
    /**
     * Rigorous Test :-)
     */
    //@Test
    public void shouldBe() {
        assertEquals(Fibonacci.calc_fib(0), 0);
        assertEquals(Fibonacci.calc_fib(1), 1);
        assertEquals(Fibonacci.calc_fib(2), 1);
        assertEquals(Fibonacci.calc_fib(3), 2);
        assertEquals(Fibonacci.calc_fib(4), 3);
        assertEquals(Fibonacci.calc_fib(5), 5);
        assertEquals(Fibonacci.calc_fib(6), 8);
    }

    //@Test
    public void lastDigit() {
        assertEquals(FibonacciLastDigit.getFibonacciLastDigitNaive(239), new BigInteger("1"));
        assertEquals(FibonacciLastDigit.getFibonacciLastDigitNaive(613455), new BigInteger("0"));
    }

    //@Test
    public void sumLastDigit() {
        assertEquals(FibonacciSumLastDigit.getFibonacciSumNaive(0), new BigInteger("0"));
        assertEquals(FibonacciSumLastDigit.getFibonacciSumNaive(1), new BigInteger("1"));
        assertEquals(FibonacciSumLastDigit.getFibonacciSumNaive(2), new BigInteger("2"));
        assertEquals(FibonacciSumLastDigit.getFibonacciSumNaive(3), new BigInteger("4"));
        assertEquals(FibonacciSumLastDigit.getFibonacciSumNaive(4), new BigInteger("7"));
    }
}
