import java.util.Scanner;

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
        Scanner scan = new Scanner(System.in);
        int cap;
        try {
            cap = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Not a valid number, retry again.");
            cap = scan.nextInt();
        }
        //TODO: call the method createRandom and pass capacity
        
        //TODO: call methods of sort algorithm  you implemented and Arrays.sort()
        // by passing sorted and unsorted arrays


    }
    /**
    * create an array of size capacity with random integer values.
     * @ param: int capacity
     * @ return: int[capacity]
     */
    public static int[] intRandArray (int capacity) {
        //TODO: implement
        return null;
    }
    /**
     * create insertion sort using the given integer array
     * @ param: int[]
     * @ return: int number of comparison
     */
    public static int insertionSort (int[] list) {
        //TODO: implement
        return 0;
    }
    /**
     * create merge sort using the given integer array
     * @ param: int[]
     * @ return: int number of comparison
     */
    public static int mergeSort (int[] list) {
        //TODO: implement
        return 0;
    }
}
