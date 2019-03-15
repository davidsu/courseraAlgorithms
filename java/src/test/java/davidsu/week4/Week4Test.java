import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.util.*;

public class Week4Test
{
    // @Test
    public void bsearch()
    {
        assertEquals( BinarySearch.binarySearch(new int[]{1,2,3}, 1), 0 );
        assertEquals( BinarySearch.binarySearch(new int[]{1,2,3}, 2), 1 );
        assertEquals( BinarySearch.binarySearch(new int[]{1,2,3}, 3), 2 );
        assertEquals( BinarySearch.binarySearch(new int[]{1,2,3}, 0), -1 );
        assertEquals( BinarySearch.binarySearch(new int[]{1,2}, 1), 0 );
        assertEquals( BinarySearch.binarySearch(new int[]{1,2}, 2), 1 );
    }

    // @Test
    public void majorityElement() {
        assertEquals(MajorityElement.getMajorityElement(new int[]{1,1,2}), 1);
        assertEquals(MajorityElement.getMajorityElement(new int[]{1,3,2}), -1);
        assertEquals(MajorityElement.getMajorityElement(new int[]{1,2,3,1}), -1);
    }

    // @Test
    public void qsort() {
        var a = new int[]{2,3,9,2,2};
        for(int q: a) System.out.print(q+" ");
        System.out.println("#############################");
        Sorting.randomizedQuickSort(a, 0, a.length -1);
        for(int q: a) System.out.print(q+" ");
        System.out.println("#############################");
        assertArrayEquals(a, new int[]{2,2,2,3,9});


         a = new int[]{10,9,8,7,6,5,4,3,2,1};
        for(int q: a) System.out.print(q+" ");
        System.out.println("#############################");
        Sorting.randomizedQuickSort(a, 0, a.length -1);
        for(int q: a) System.out.print(q+" ");
        System.out.println("#############################");
        assertArrayEquals(a, new int[]{1,2,3,4,5,6,7,8,9,10});
    }

    @Test
    public void inversions() {
        int[] a;
        a = new int[]{2,3,9,2,9};
        assertEquals(Inversions.getNumberOfInversions(a, new int[a.length], 0, a.length-1), 2);
        a = new int[]{9,8,7,3,2,1};
        assertEquals(Inversions.getNumberOfInversions(a, new int[a.length], 0, a.length-1), 15);
        a = new int[]{7,8,9,2,3,1};
        assertEquals(Inversions.getNumberOfInversions(a, new int[a.length], 0, a.length-1), 11);
    }
}
