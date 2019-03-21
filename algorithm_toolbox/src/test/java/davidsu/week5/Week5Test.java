
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.util.*;

public class Week5Test {

    //@Test
    public void change() {
        assertEquals(ChangeDP.getChange(2), 2);
        assertEquals(ChangeDP.getChange(34), 9);
    }

    //@Test
    public void distance() {
        assertEquals(EditDistance.EditDistance("ab", "ab"), 0);
        assertEquals(EditDistance.EditDistance("short", "ports"), 3);
        assertEquals(EditDistance.EditDistance("editing", "distance"), 5);
    }

    //@Test
    public void lcs2() {
        assertEquals(LCS2.lcs2(new int[]{2,7,5}, new int[]{2,5}), 2);
        assertEquals(LCS2.lcs2(new int[]{7}, new int[]{1,2,3,4}), 0);
        assertEquals(LCS2.lcs2(new int[]{2,7,8,3}, new int[]{5,2,8,7}), 2);
    }
    //@Test
    public void lcs3(){
        assertEquals(LCS3.lcs3(new int[]{1,2,3}, new int[]{2,1,3}, new int[]{1,3,5}), 2);
        assertEquals(LCS3.lcs3(new int[]{8,3,2,1,7}, new int[]{8,2,1,3,8,10,0,7}, new int[]{6,8,3,1,0,7}), 3);
    }
    //@Test
    public void primitivecala1() {
        assertEquals(PrimitiveCalculator.optimal_sequence(5), List.of(1,2,4,5));
        assertEquals(PrimitiveCalculator.optimal_sequence(96234).size(), 15);
    }
    //@Test
    public void primitivecala() {
        assertEquals(PrimitiveCalculator.optimal_sequence(5), List.of(1,2,4,5));
        assertEquals(PrimitiveCalculator.optimal_sequence(96234), List.of(1, 3, 9, 10, 11, 22, 66, 198, 594, 1782, 5346, 16038, 16039, 32078, 96234));
    }
}
