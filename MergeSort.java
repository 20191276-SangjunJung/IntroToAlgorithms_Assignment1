public class MergeSort {
    public static void mergeSort(int[] A, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;

        // divide the problem until the base case
        mergeSort(A, p, q);
        mergeSort(A, q + 1, r);

        // merge two sorted subproblems
        merge(A, p, q, r);
    }

    public static void merge(int[] A, int p, int q, int r) {
        // for the convinience
        int n1 = q - p + 1;
        int n2 = r - q;

        // temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // copying the elements in A into L and R
        for (int a = 0; a < n1; a++) {
            L[a] = A[p + a];
        }
        for (int b = 0; b < n2; b++) {
            R[b] = A[q + 1 + b];
        }

        int i = 0, j = 0;
        int k = p;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            }
            else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        // in case, if there is leftover in each array
        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }
}