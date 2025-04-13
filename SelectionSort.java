public class SelectionSort {

    public static void selectionSort(int[] A) {    // get array A as an input
        int n = A.length;                           // length of an array, number of elements

        for (int i = 0; i < n - 1; i++) {           // i is 0 to n-2
            int min = i;                            // min to remember the smallest value's index
            for (int j = i + 1; j < n; j++) {       // j is i+1 to n
                if (A[j] < A[min]) {                // if there is smaller value
                    min = j;                        // remember that index
                }
            }

            // swap A[j] with A[min]
            int temp = A[i];
            A[i] = A[min];
            A[min] = temp;
        }
    }
}