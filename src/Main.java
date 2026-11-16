void main() {
    int[] test = ComparisonSort.intRandArray(5);
    int comparisonUnsorted = 0;
    int comparisonSorted = 0;

    comparisonUnsorted = ComparisonSort.mergeSort(test);
    comparisonSorted = ComparisonSort.mergeSort(test);

    IO.println(comparisonSorted);
    IO.println(comparisonUnsorted);

    /*
    for(int i = 0 ; i < test.length; i++){
        IO.println(test[i]);
    }

     */
}
