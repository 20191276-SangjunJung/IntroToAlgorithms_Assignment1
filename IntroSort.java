import java.util.Arrays;

public class IntroSort {
    static final int THRESHOLD = 16;

    public static void introSort(int[] A) {
        int n = A.length;
        int depthlimit = 2 * (int)(Math.floor(Math.log(n) / Math.log(2)));
        introSorting(A, 0, n - 1, depthlimit);
    }

    public static void introSorting(int[] A, int start, int end, int depthlimit) {
        int size = end - start + 1;

        // if the size is smaller than threshold, do insertion sort
        if (size < THRESHOLD) {
            insertionSort(A, start, end);
            return;
        }

        // if the depth is too deep, do heap sort
        if (depthlimit == 0) {
            heapSort(A, start, end);
            return;
        }

        // quick sort
        int pivot = partition(A, start, end);
        introSorting(A, start, pivot - 1, depthlimit - 1);
        introSorting(A, pivot + 1, end, depthlimit - 1);
    }

    private static int partition(int[] A, int low, int high) {
        int pivot = A[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (A[j] <= pivot) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, high);
        return i + 1;
    }

    private static void insertionSort(int[] A, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int key = A[i];
            int j = i - 1;
            while (j >= start && A[j] > key) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = key;
        }
    }

    private static void heapSort(int[] A, int start, int end) {
        int size = end - start + 1;
        for (int i = start + size / 2 - 1; i >= start; i--) {
            maxHeapify(A, start, end, i);
        }
        for (int i = end; i > start; i--) {
            swap(A, start, i);
            maxHeapify(A, start, i - 1, start);
        }
    }

    private static void maxHeapify(int[] A, int start, int end, int root) {
        int largest = root;
        int left = start + 2 * (root - start) + 1;
        int right = start + 2 * (root - start) + 2;

        if (left <= end && A[left] > A[largest])
            largest = left;
        if (right <= end && A[right] > A[largest])
            largest = right;

        if (largest != root) {
            swap(A, root, largest);
            maxHeapify(A, start, end, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}