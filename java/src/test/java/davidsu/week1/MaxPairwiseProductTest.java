import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class MaxPairwiseProductTest 
{
    // @Test
    public void shouldBe6() {
        assertEquals(MaxPairwiseProduct.getMaxPairwiseProduct(new int[]{1,2,3}), 6);
    }
    // @Test
    public void bigNumbers() {
        assertEquals(MaxPairwiseProduct.getMaxPairwiseProduct(new int[]{100000,90000}), 9000000000L);
    }
}
