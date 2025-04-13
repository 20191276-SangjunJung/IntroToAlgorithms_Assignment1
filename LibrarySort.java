import java.util.Arrays;

public class LibrarySort {

    private static final double GAP_RATIO = 1.5; // epsilon value

    public static int[] librarySort(int[] A) {
        int n = A.length;
        int capacity = (int) ((1 + GAP_RATIO) * n) + 1;
        Integer[] S = new Integer[capacity];
        int size = 1;                                           // current count of the input

        int middle = capacity / 2;
        S[middle] = A[0];                                       // first value in the middle

        for (int i = 1; i < n; i++) {
            int position = binarySearch(S, A[i]);               // using binary search to find the place to insert
            
            if (position >= S.length) {
                position = S.length - 1;
            }

            if (S[position] == null) {                          // if empty, insert
                S[position] = A[i];
            } else {
                position = shiftAndInsert(S, position, A[i]);   // if not empty, shift to the right until there is a place to insert
            }

            size++;
            if (isPowerOfTwo(size)) {                           // if the size is the power of two, rebalance the gaps
                S = rebalance(S, size);
            }
        }

        return extractSortedArray(S);                           // remove empty spaces
    }

    private static int binarySearch(Integer[] S, int target) {  // binary search without the null
        int left = 0, right = S.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (S[mid] == null) {
                // Find nearest value
                int l = mid - 1, r = mid + 1;
                while (true) {
                    if (l < left && r > right) return mid;
                    if (l >= left && S[l] != null) {
                        mid = l;
                        break;
                    }
                    if (r <= right && S[r] != null) {
                        mid = r;
                        break;
                    }
                    l--;
                    r++;
                }
            }

            if (S[mid] == null || S[mid] == target)
                return mid;
            else if (S[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return Math.min(left, S.length - 1);
    }


    private static int shiftAndInsert(Integer[] S, int index, int value) {
        // Try right side first
        if (index + 1 < S.length) {
            for (int i = index + 1; i < S.length; i++) {
                if (S[i] == null) {
                    System.arraycopy(S, index, S, index + 1, i - index);
                    S[index] = value;
                    return index;
                }
            }
        }
    
        // Try left side
        for (int i = index - 1; i >= 0; i--) {
            if (S[i] == null) {
                System.arraycopy(S, i + 1, S, i, index - i);
                S[index] = value;
                return index;
            }
        }
    
        throw new RuntimeException("No space: " + value);
    }

    private static boolean isPowerOfTwo(int x) {
        return (x & (x - 1)) == 0;
    }
    
    private static Integer[] rebalance(Integer[] S, int insertedSize) {
        int new_Capacity = (int) ((1 + GAP_RATIO) * insertedSize) + 1;      // rearrange the array with gaps betweeen elements
        Integer[] new_S = new Integer[new_Capacity];
        int gap = Math.max(1, (new_Capacity - insertedSize) / insertedSize);


        int index = 0;
        for (Integer val : S) {
            if (val != null) {
                if (index >= new_S.length) break;
                new_S[index] = val;                                         // insert the values with making gap
                index += gap + 1;
            }
        }

        return new_S;
    }

    private static int[] extractSortedArray(Integer[] S) {
        int count = 0;
    
        // count the values
        for (Integer value : S) {
            if (value != null) {
                count++;
            }
        }
    
        // making a result array
        int[] result = new int[count];
        int index = 0;
    
        for (Integer value : S) {
            if (value != null) {
                result[index++] = value;
            }
        }
    
        return result;
    }
}
