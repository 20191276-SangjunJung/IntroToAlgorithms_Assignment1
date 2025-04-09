public class HeapSort {

    public static void heapSort(int[] A) {
        int n = A.length;                   // the number of elements

        buildMaxHeap(A, n);                 // building a max-heap

        for (int i = n - 1; i > 0; i--) {
            // swap the first and the last value
            int temp_ = A[0];
            A[0] = A[i];
            A[i] = temp_;
            n--;
            maxHeapify(A, i, 0);            // keep the max-heap property
        }
    }

    public static void maxHeapify(int[] A, int n, int i) { 
        int left = 2 * i;                       // left child node of i
        int right = 2 * i + 1;                  // right child node of i
        int largest = i;                        // initialize the largest
        if (left < n && A[left] > A[i]) {      // if A[left], left child node is larger
            largest = left;
        }
        if (right < n && A[right] > A[i]) {    // if right child node is larger
            largest = right;
        }
        if (largest != i) {                     // if parent node is not the largest
            // swap parent node with the largest
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            maxHeapify(A, n, largest);
        }

    }

    public static void buildMaxHeap(int[] A, int n) {
        for (int i = (n / 2) - 1; i >= 0; i--) {
            maxHeapify(A, n, i);
        }
    }
}