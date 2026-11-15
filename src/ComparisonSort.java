import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

/**********************
Name(s): Randy D. Peter W.

Responsibilities Descriptions:


Sources you used:
 (1) geeksforgeeks.com

***********************/
public class ComparisonSort {
    public static void main(){
        int capacity;
        //TODO: ask user to enter the capacity
        System.out.println("Enter an integer to determine capacity of the array.");
        Scanner scan = new Scanner(System.in);
        int cap;
        try {
            cap = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Not a valid number, retry again.");
            cap = scan.nextInt();
        }
        //TODO: call the method createRandom and pass capacity
        int[] randomArray = intRandArray(cap);
        //TODO: call methods of sort algorithm  you implemented and Arrays.sort()
        // by passing sorted and unsorted arrays
        insertionSort(randomArray);
        mergeSort(randomArray);
        Arrays.sort(randomArray);
    }
    /**
    * create an array of size capacity with random integer values.
     * @ param: int capacity
     * @ return: int[capacity]
     *  (1) intRandArray(3) -> {-91, 0, 9999735}
     */
    public static int[] intRandArray (int capacity) {
        //TODO: implement
        int[] random = new int[capacity];
        Random r = new Random();
        for (int i = 0; i < random.length; i++) {
            int num = r.nextInt(2 * Integer.MAX_VALUE) - Integer.MAX_VALUE;
            random[i] = num;
        }
        return random;
    }
    /**
     * create insertion sort using the given integer array
     * @ param: int[]
     * @ return: int number of comparison
     * @author: geeksforgeeks.com
     * (1) {3, 5, 0, 2} -> insertionSort() -> {0, 2, 3, 5}
     *
     */
    public static int insertionSort (int[] list) {
        //TODO: implement
        int n = list.length;
        int comparisons = 0;
        for (int i = 1; i < n; ++i) {
            int k = list[i];
            int j = i - 1;
            while (j >= 0 && list[j] > k) {
                list[j + 1] = list[j];
                j = j - 1;
            }
            list[j + 1] = k;
        }
        return comparisons;
    }
    /**
     * create merge sort using the given integer array
     * @ param: int[]
     * @ return: int number of comparison
     * (1) {3, 5, 0, 2} -> mergeSort() -> {0, 2, 3, 5}
     */
    public static int mergeSort (int[] list) {
        //TODO: implement
        return 0;
    }

    /*
    *  merges the arrays together, helper method for the mergeSort method.
    *  @param...
    *  @return...
     */
    private static void merge() {
         
    }
}
