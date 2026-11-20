import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

/**********************
Name(s): Randy D. Peter W.

Responsibilities Descriptions:
Randy D.: Insertion Sort and checking number of comparisons
 Peter W.:  Merge Sort, plotting, filling out table

 All: Test cases and Questions for Lab 8.

Sources you used:
 (1) geeksforgeeks.com
 (2) ChatGPT (vibe coded Merge Sort -> approved by Professor)

***********************/
public class ComparisonSort {
    private static int mComparison = 0;

    public static void main() {
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
        int[] randomArray1 = Arrays.copyOf(randomArray, randomArray.length);
        int[] randomArray2 = Arrays.copyOf(randomArray, randomArray.length);
        //TODO: call methods of sort algorithm  you implemented and Arrays.sort()
        // by passing sorted and unsorted arrays

        long startInsertTime = System.nanoTime();
        int comparisonsInsertion = insertionSort(randomArray);
        long endInsertTime = System.nanoTime();
        long insertDuration = ((endInsertTime - startInsertTime) / 1000000);
        System.out.println("Insertion sort of " + cap + " elements took " + insertDuration + " ms and " + comparisonsInsertion + " comparisons.");

        long startMergeTime = System.nanoTime();
        int mergeComparisons = mergeSort(randomArray1);
        long endMergeTime = System.nanoTime();
        long mergeDuration = ((endMergeTime - startMergeTime) / 1000000);
        System.out.println("Merge sort of " + cap + " elements took " + mergeDuration + " ms and " + mergeComparisons + " comparisons.");

        long startTime = System.nanoTime();
        Arrays.sort(randomArray2);
        long endTime = System.nanoTime();
        long duration = ((endTime - startTime) / 1000000);
        System.out.println("Java array sort of " + cap + " elements took " + duration + " ms.");

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
     * (1) {5, 3, 2, 0} -> insertionSort() -> {0, 2, 3, 5} -> returns 10
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
     * Sorts the array using merge sort and counts element comparisons in mComparison.
     * @param list the array to sort
     * @return the sorted array
     * (1) {3, 5, 0, 2} -> mergeSortResultTwo() -> {0, 2, 3, 5}
     */
    public static int[] mergeSortResultTwo(int[] list) {
        if (list.length <= 1) {
            return list;
        }

        int middle = list.length / 2;
        int[] left = mergeSortResultTwo(Arrays.copyOfRange(list, 0, middle));
        int[] right = mergeSortResultTwo(Arrays.copyOfRange(list, middle, list.length));
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (true) {
            if (leftIndex >= left.length) {
                break;
            }
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
            if (leftIndex >= left.length) {
                break;
            }
            list[resultIndex++] = left[leftIndex++];
        }
        while (true) {
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
     * (1) {1, 2, 3, 4, 5, 6, 7, 8} -> mergeSort() -> returns 12
     */
    public static int mergeSort (int[] list) {
        mComparison = 0;
        mergeSortResultTwo(list);
        return mComparison;
    }
}
