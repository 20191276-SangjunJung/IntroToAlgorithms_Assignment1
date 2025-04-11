import java.util.Arrays;

public class TimSort {
    public static void timSort(int[] A) {
        int n = A.length;
        int minRun = calculateminRun(n);                                    // determine the minRun value

        // Divide the array to runs and sort with the insertion sort
        for (int i = 0; i < n; i += minRun) {                               // from start to n in steps of minRun
            int end = Math.min(i + minRun - 1, n - 1);                      // normally the end is i + minRun - 1, but even if it reached the last of the array
                                                                            // and still smallert than minRun, then end is the last of the array
            insertionSort(A, i, end);                                       // sort the run with the insertion sor
        }

        // Merge the runs
        for (int size = minRun; size < n; size = 2 * size) {                // because it needs to merge so steps are 2 * size
            for (int left = 0; left < n; left += 2 * size) {
                int mid = Math.min(left + size - 1, n - 1);                 // the end of the first run
                int right = Math.min(left + 2 * size - 1, n - 1);           // the end of the second run

                if (mid < right)
                    merge(A, left, mid, right);
            }
        }
    }

    public static int calculateminRun(int n) {
        int r = 0;
        while (n >= 64) {
            r |= (n & 1);
            n >>= 1;                                                        // divide by 2
        }
        return n + r;
    }

    public static void insertionSort(int[] A, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int temp = A[i];
            int j = i - 1;
            while (j >= start && A[j] > temp) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = temp;
        }
    }

    public static void merge(int[] A, int l, int m, int r) {
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];

        for (int i = 0; i < len1; i++) left[i] = A[l + i];
        for (int i = 0; i < len2; i++) right[i] = A[m + 1 + i];

        int i = 0, j = 0, k = l;

        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) A[k++] = left[i++];
            else A[k++] = right[j++];
        }

        while (i < len1) A[k++] = left[i++];
        while (j < len2) A[k++] = right[j++];
    }
}
