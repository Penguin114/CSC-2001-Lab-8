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
    private static int mComparison = 0;

    public static void main(){
        //TODO: ask user to enter the capacity
        System.out.println("Enter an integer to determine capacity of the array.");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.out.println("Not a valid number. Try again.");
            scan.next();
        }
        int cap = scan.nextInt();
        //TODO: call the method createRandom and pass capacity
        int[] randomArray = intRandArray(cap);
        //TODO: call methods of sort algorithm  you implemented and Arrays.sort()
        // by passing sorted and unsorted arrays


        long startTime = System.nanoTime();
        int comparisons = insertionSort(randomArray);
        // mergeSort(randomArray);
        // Arrays.sort(randomArray);
        long endTime = System.nanoTime();
        long duration = ((endTime - startTime) / 1000000);
        System.out.println("Insertion sort of " + cap + " elements took " + duration + " ms and " + comparisons + " comparisons.");
    }
    /**
    * create an array of size capacity with random integer values.
     * @ param: int capacity
     * @ return: int[capacity]
     *  (1) intRandArray(3) -> {-91, 0, 9999735}
     */
    public static int[] intRandArray(int capacity) {
        //TODO: implement
        int[] random = new int[capacity];
        Random r = new Random();
        for (int i = 0; i < random.length; i++) {
            int num = r.nextInt();
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
                comparisons++;
                list[j + 1] = list[j];
                j = j - 1;
            }
            if (j >= 0) {
                comparisons++;
            }
            list[j + 1] = k;
        }
        return comparisons;
    }
    /**
     * Sorts the array using merge sort and counts each comparison in mComparison.
     * @param list the array to sort
     * @return the sorted array
     */
    public static int[] mergeSortResult(int[] list) {
        mComparison++;
        if (list.length <= 1) {
            return list;
        }

        int middle = list.length / 2;
        int[] left = mergeSortResult(Arrays.copyOfRange(list, 0, middle));
        int[] right = mergeSortResult(Arrays.copyOfRange(list, middle, list.length));
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (true) {
            mComparison++;
            if (leftIndex >= left.length) {
                break;
            }
            mComparison++;
            if (rightIndex >= right.length) {
                break;
            }
            mComparison++;
            if (left[leftIndex] <= right[rightIndex]) {
                list[resultIndex++] = left[leftIndex++];
            } else {
                list[resultIndex++] = right[rightIndex++];
            }
        }

        while (true) {
            mComparison++;
            if (leftIndex >= left.length) {
                break;
            }
            list[resultIndex++] = left[leftIndex++];
        }
        while (true) {
            mComparison++;
            if (rightIndex >= right.length) {
                break;
            }
            list[resultIndex++] = right[rightIndex++];
        }
        return list;
    }

    /**
     * TODO: vibe code this and make sure AI does not make improvement to this algorithm.
     * create merge sort using the given integer array
     * @ param: int[]
     * @ return: int number of comparison
     */
    public static int mergeSort (int[] list) {
        mComparison = 0;

        mergeSortResult(list);

        return mComparison;
    }

    /*
    *  merges the arrays together, helper method for the mergeSort method.
    *  @param...
    *  @return...
     */
    /*
    private static void merge(int[] list, int l, int m, int r) {
    // TODO: implement

        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = list[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = list[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                list[k] = L[i];
                i++;
            }
            else {
                list[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            list[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            list[k] = R[j];
            j++;
            k++;
        }
    }
     */
}
