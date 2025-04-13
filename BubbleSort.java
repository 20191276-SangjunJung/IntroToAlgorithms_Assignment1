public class BubbleSort {
    public static void bubbleSort(int[] A) {
        int n = A.length;                           // number of elements
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {           // bubble sort compares adjacent elements, so last index has to be n-2 to be compared
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {   // after i sorts, the last i elements are sorted in order, no need to include in the sorting again
                if (A[j] > A[j + 1]) {              // if the front element is larger

                    // swaping procedure
                    int temp = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = temp;

                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }
}