public class CocktailShakerSort {
    public static void cocktailShakerSort(int[] A) {
        boolean swapped = true;
        int start = 0;
        int end = A.length - 1;

        while (swapped) {
            swapped = false;

            // bubble sort left to right
            for (int i = start; i < end; i++) {
                if (A[i] > A[i + 1]) {
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;                    // if there is no more swap

            swapped = false;
            end--;                                  // end element is sorted

            // bubble sort right to left
            for (int i = end - 1; i >= start; i--) {
                if (A[i] > A[i + 1]) {
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                }
            }

            start++;                                // start element is sorted
        }
    }
}