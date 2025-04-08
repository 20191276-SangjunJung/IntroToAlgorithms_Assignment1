public class InsertionSortTwoArrays {
    
    public static int[] insertionSortWithTwoArrays(int[] A) { // Array A as a hand
        int n = A.length;
        int[] B = new int[n]; // Array B as a table
        int b_len = 0;

        for (int i = 0; i < n; i++) {
            int key = A[i];
            int j;

            for (j = b_len; j > 0 && B[j - 1] > key; j--) {
                B[j] = B[j - 1];
            }

            B[j] = key;
            b_len++;
        }

        return B;
    }
}
