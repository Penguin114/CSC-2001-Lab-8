import org.junit.Test;

import static org.junit.Assert.*;

public class ComparisonSortTests {
    @Test
    public void mergeSortTest(){
        int[] l = {5,4,3,2,1};
        assertArrayEquals(new int[]{1,2,3,4,5}, ComparisonSort.mergeSortResultTwo(l));

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, ComparisonSort.mergeSortResultTwo(a));
        assertEquals(12, ComparisonSort.mergeSort(a));

        int[] a2 = {8, 7, 6, 5, 4, 3, 2, 1};
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, ComparisonSort.mergeSortResultTwo(a2));
        assertEquals(12, ComparisonSort.mergeSort(a2));

        /* need to test this on the board later.
        int[] a3 = {8, 4, 6, 2, 7, 3, 5, 1};
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, ComparisonSort.mergeSortResultTwo(a3));
        assertEquals(12, ComparisonSort.mergeSort(a3));
        */

        int[] randomArray = ComparisonSort.intRandArray(50);
        int[] sortedArray = ComparisonSort.mergeSortResultTwo(randomArray);
        boolean sorted = true;
        int maximum = sortedArray[0];
        for (int i = 1; i < sortedArray.length; i++) {
            if (maximum < sortedArray[i]) {
                maximum = sortedArray[i];
            }
        }
        assertTrue(sorted);
    }

    @Test
    public void insertionSortTest(){
        int[] list = {5, 2, 3, 1, 4};
        int numComparison = ComparisonSort.insertionSort(list);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, list);
        assertEquals(8, numComparison);
    }
}
