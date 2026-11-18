void main() {
    int[] test = {1,2,3,4,5};
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
