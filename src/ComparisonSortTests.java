import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ComparisonSortTests {
    /*
    @Test
    public void mergeSortTest(){
        int[] l = {5,4,3,2,1};
        assertArrayEquals(new int[]{1,2,3,4,5}, ComparisonSort.mergeSortResultTwo(l));
    }

     */
    @Test
    public void insertionSortTest(){
        int[] list = {5, 2, 3, 1, 4};
        int numComparison = ComparisonSort.insertionSort(list);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, list);
        assertEquals(8, numComparison);
    }


}
