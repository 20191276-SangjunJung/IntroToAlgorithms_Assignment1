public class CombSort {
    public static void combSort(int[] A) {
        int n = A.length;
        double shrink = 1.3;
        int gap = n;
        boolean swapped = true;                     // to check if the sorting have finished

        while (gap > 1 || swapped) {
            gap = (int)(gap/shrink);                // shrink is type double and need the integer value of gap
            if (gap < 1) gap = 1;                   // if gap gets smaller than 1, set the gap 1
            swapped = false;
            for (int i = 0; i < n - gap; i++) {
                // swapping process
                if (A[i] > A[i + 1]) {
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                    swapped = true;
                }
            }
        }
    }
}