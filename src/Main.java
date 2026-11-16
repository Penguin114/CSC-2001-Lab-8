void main() {
    int[] test = {5, 4, 3, 2, 1};
    int comparisonUnsorted = 0;
    int comparisonSorted = 0;

    comparisonUnsorted = ComparisonSort.mergeSort(test);
    comparisonSorted = ComparisonSort.mergeSort(test);

    IO.println(comparisonUnsorted);
    IO.println(comparisonSorted);

    /*
    for(int i = 0 ; i < test.length; i++){
        IO.println(test[i]);
    }

     */
}
