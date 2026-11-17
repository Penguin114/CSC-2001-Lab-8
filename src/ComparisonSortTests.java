import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ComparisonSortTests {
    @Test
    public void mergeSortTest(){
        int[] l = {5,4,3,2,1};
        assertArrayEquals(new int[]{1,2,3,4,5}, ComparisonSort.mergeSortResult(l));
    }
}
