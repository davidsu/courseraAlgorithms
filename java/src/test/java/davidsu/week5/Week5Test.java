
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.util.*;

public class Week5Test {

    @Test
    public void change() {
        assertEquals(ChangeDP.getChange(2), 2);
        assertEquals(ChangeDP.getChange(34), 9);
    }

    @Test
    public void distance() {
        // assertEquals(EditDistance.EditDistance("", ""), 0)
    }

    public void lcs2() {
        // assertEquals(LCS2.lcs2(), 0);
    }
    public void lcs3(){
        // assertEquals(LCS3.lcs3(), 0);
    }
    @Test
    public void primitivecala1() {
        assertEquals(PrimitiveCalculator.optimal_sequence(5), List.of(1,2,4,5));
        assertEquals(PrimitiveCalculator.optimal_sequence(96234).size(), 15);
    }
    @Test
    public void primitivecala() {
        assertEquals(PrimitiveCalculator.optimal_sequence(5), List.of(1,2,4,5));
        assertEquals(PrimitiveCalculator.optimal_sequence(96234), List.of(1, 3, 9, 10, 11, 22, 66, 198, 594, 1782, 5346, 16038, 16039, 32078, 96234));
    }
}
