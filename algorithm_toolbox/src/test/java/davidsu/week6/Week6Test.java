import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.util.*;

public class Week6Test {

    @Test
    public void change() {
        assertEquals(Knapsack.optimalWeight(10, new int[]{1,4,8}), 9);
    }

    // @Test
    // public void partition_hasValid() {
    //     assertEquals(Partition3.hasValidPartition(new int[][]{
    //         //        0 1 2 3 4 5 6
    //         new int[]{0,3,3,3,3,3,3},//3
    //         new int[]{0,3,3,3,6,6,6},//3
    //         new int[]{0,3,3,3,6,6,6},//3
    //     }, new int[]{3,3,3},  3), 1);
    //     assertEquals(Partition3.hasValidPartition(new int[][]{
    //         //        0 1 2 3 4
    //         new int[]{0,1,1,1,1},//1
    //         new int[]{0,2,3,3,3},//2
    //         new int[]{0,3,3,3,3},//3
    //     }, new int[]{1,2,3},  2), 0);
    //     assertEquals(Partition3.hasValidPartition(new int[][]{
    //         //        0 1 2 3 4
    //         new int[]{0,1,1,1,1},//1
    //         new int[]{0,2,2,3,3},//2
    //         new int[]{0,2,2,3,4},//2
    //         new int[]{0,1,2,3,4},//1
    //     }, new int[]{1,2,2,1},  2), 1);
    // }
    // @Test
    public void partition() {
        assertEquals(Partition3.partition3(new int[]{3,3,3,3}), 0);
        assertEquals(Partition3.partition3(new int[]{3,3,3}), 1);
        assertEquals(Partition3.partition3(new int[]{40}), 0);
        assertEquals(Partition3.partition3(new int[]{5, 6, 3, 3, 1}), 1);
        assertEquals(Partition3.partition3(new int[]{59,67,57,34,17,2,18,40,60}), 1);
        assertEquals(Partition3.partition3(new int[]{59,34,57,17,40,67,18,2,60}), 1);
        assertEquals(Partition3.partition3(new int[]{17,59,34,57,17,23,67,1,18,2,59}), 1);
        assertEquals(Partition3.partition3(new int[]{1,2,3,4,5,5,7,7,8,10,12,19,25}), 1);
    }
}
