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

        int[] a2 = {8, 2, 4, 6, 7, 1, 5, 3};
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, ComparisonSort.mergeSortResultTwo(a2));
        assertEquals(12, ComparisonSort.mergeSort(a2));

        int[] a3 = {8, 1, 1, 4, 5, 9, 10, 33};
        assertArrayEquals(new int[]{1, 1, 4, 5, 8, 9, 10, 33}, ComparisonSort.mergeSortResultTwo(a3));
        assertEquals(12, ComparisonSort.mergeSort(a3));

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

        randomArray = ComparisonSort.intRandArray(9999);
        sortedArray = ComparisonSort.mergeSortResultTwo(randomArray);
        sorted = true;
        maximum = sortedArray[0];
        for (int i = 1; i < sortedArray.length; i++) {
            if (maximum < sortedArray[i]) {
                maximum = sortedArray[i];
            }
        }
        assertTrue(sorted);
    }
}
