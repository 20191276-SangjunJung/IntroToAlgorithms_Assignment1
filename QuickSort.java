public class QuickSort {
    public static void quickSort(int[] A, int p, int r) {
        if (p < r) {                            // p is the start of an array and r is the last of an array, checking if it is working in the array
            int q = partition(A, p, r);         // make a partition with the pivot q
            
            // recursive calls until it reaches the base case
            quickSort(A, p, q - 1);             
            quickSort(A, q + 1, r);
        }
    }

    public static int partition(int[] A, int p, int r) {
        int pivot = A[r];
        int i = p - 1;                          // i is for the index of the last element smaller than pivot
        for (int j = p; j < r; j++) {           // j is for the index to keep the current value of the array A
            if (A[j] <= pivot) {                // value smaller than pivot
                i++;

                // swapping A[i] with A[j], keeps elements of A[p:i] are smaller than pivot
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp_ = A[i + 1];
        A[i + 1] = A[r];
        A[r] = temp_;
        return i + 1;
    }
}