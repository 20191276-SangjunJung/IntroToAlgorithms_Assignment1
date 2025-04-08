public class InsertionSortOneArray {

    public static int[] insertionSortWithOneArray(int[] A) {
        int n = A.length;                                       // to get the number of input
        for (int i = 2; i < n; i++) {                           // starting from 2 because we are using one array and first element is for the comparison
            int key = A[i];
            int j = i - 1;                                      // index right before the element
            while (j >= 0 && A[j] > key) {                      // while j is the index of an array and element is larger than key, finding the right place to insert
                A[j + 1] = A[j];                                // value shift
                j = j - 1;                                      // index switch
            }
            A[j + 1] = key;
        }
    }
}