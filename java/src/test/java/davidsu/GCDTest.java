import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GCDTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void gcd() {
        assertEquals(GCD.gcd_naive(7, 14), 7);
        assertEquals(GCD.gcd_naive(25, 30), 5);
        assertEquals(GCD.gcd_naive(45, 81), 9);
    }
    @Test
    public void lcm() {
        assertEquals(LCM.lcm_naive(10, 15), 30);
    }
    // public void bigNumbers() {
    //     assertEquals(MaxPairwiseProduct.getMaxPairwiseProduct(new int[]{100000,90000}), 9000000000L);
    // }
}
