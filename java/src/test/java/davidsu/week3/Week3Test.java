import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class Week3Test
{
    // @Test
    public void shouldAnswerWithTrue()
    {
        assertEquals(CarFueling.computeMinRefills(1, 3, new int[]{1,2,3,4,5,6,7,8,9,10}), 0);
        assertEquals(CarFueling.computeMinRefills(10, 1, new int[]{1,2,3,4,5,6,7,8,9,10}), 9);
        assertEquals(CarFueling.computeMinRefills(4, 3, new int[]{1,2,3,4,5,6,7,8,9,10}), 1);
        assertEquals(CarFueling.computeMinRefills(10, 3, new int[]{1,2,3,4,5,6,7,8,9,10}), 3);
        assertEquals(CarFueling.computeMinRefills(1, 1, new int[]{1}), 0);
        assertEquals(CarFueling.computeMinRefills(2, 1, new int[]{1, 2}), 1);
        assertEquals(CarFueling.computeMinRefills(50, 20, new int[]{25, 30, 40}), -1);
        assertEquals(CarFueling.computeMinRefills(950, 400, new int[]{200, 375, 550, 750}), 2);
        assertEquals(CarFueling.computeMinRefills(700, 200, new int[]{100, 200, 300, 400}), -1);
        assertEquals(CarFueling.computeMinRefills(700, 200, new int[]{100, 400, 600}), -1);
        assertEquals(CarFueling.computeMinRefills(00, 00, new int[]{100, 200, 300, 400}), 0);
    }
    // @Test
    public void fractional_Knapsack()
    {
        assertEquals(FractionalKnapsack.getOptimalValue(10, new int[]{1}, new int[]{10}),  1, 0);
        assertEquals(FractionalKnapsack.getOptimalValue(10, new int[]{2}, new int[]{10}),  2, 0);
        assertEquals(FractionalKnapsack.getOptimalValue(10, new int[]{5, 10}, new int[]{1, 10}),  14, 0);
    }

    // @Test
    public void change() {
        assertEquals(Change.getChange(10), 1);
        assertEquals(Change.getChange(3), 3);
        assertEquals(Change.getChange(16), 3);
    }

    @Test
    public void segments() {
        CoveringSegments.Segment[] segs = new CoveringSegments.Segment[]{
            new CoveringSegments.Segment(1,3), 
            new CoveringSegments.Segment(2,5), 
            new CoveringSegments.Segment(3,6)
        };
        int[] res1 = CoveringSegments.optimalPoints(segs);
        int[] expected1 = new int[]{3};
        // assertEquals(expected1, res1);
        assertArrayEquals(expected1, res1);
        assertArrayEquals(CoveringSegments.optimalPoints(new CoveringSegments.Segment[]{
            new CoveringSegments.Segment(4,7), 
            new CoveringSegments.Segment(1,3), 
            new CoveringSegments.Segment(2,5),
            new CoveringSegments.Segment(5,6)
        }), new int[]{3,6});
    }
}
