import java.util.*;

public class GenerateInput {
    static Random rand = new Random();

    // get the random size of an array in the range of 1000~1000000
    public static int getRandomSize() {
        //return rand.nextInt(10000 - 1000 + 1) + 1000;
        return rand.nextInt(1_000_000 - 1000 + 1) + 1000;
    }

    // Sorted Data
    public static int[] getSortedArray() {
        int[] A = getRandomArray();                 // get the random array
        Arrays.sort(A);                             // sort in ascending order
        return A;
    }

    // Random Data
    public static int[] getRandomArray() {
        int size = getRandomSize();                 // get the size
        int[] A = new int[size];
        for (int i = 0; i < size; i++) {
            A[i] = rand.nextInt(1_000_000) + 1;     // random number in each index
        }
        return A;
    }

    // Reversed Data
    public static int[] getReverseArray() {
        int[] A =getSortedArray();
        // reversing process
        int left = 0, right = A.length - 1;
        while (left < right) {
            int temp = A[left];
            A[left++] = A[right];
            A[right--] = temp;
        }
        return A;
    }

    // Partially Sorted Data
    public static int[] getPartiallySortedArray() {
        int[] A = getRandomArray();
        // assume the half is sorted
        int half = A.length / 2;
        Arrays.sort(A, 0, half);
        return A;
    }

    public static void test() {
        
        // change the name of the sort
        System.out.println("====== Comb Sort ======\n");

        // Sorted
        long totalTime_Sorted = 0;
        long totalMemory_Sorted = 0;
        long totalLength_Sorted = 0;

        for (int i = 1; i <= 10; i++) {
            int[] A1 = getSortedArray();
            System.out.println("Length of the array " + i + ": " + A1.length);
            totalLength_Sorted += A1.length;

            Runtime runtime = Runtime.getRuntime();
            runtime.gc();
            long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
            
            long timeStart = System.nanoTime();

            // change the sort
            combSort(A1);
    
            long timeEnd = System.nanoTime();

            long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

            long memoryUsed = memoryAfter - memoryBefore;
            long duration = timeEnd - timeStart;

            totalTime_Sorted += duration;
            System.out.println("totalTime: " + totalTime_Sorted);
            totalMemory_Sorted += memoryUsed;
            
        }

        System.out.println("Average length for Sorted Array: " + totalLength_Sorted / 10);
        System.out.println("Execution Time for Sorted Array: " + totalTime_Sorted / 10 + " ns");
        System.out.println("Memory Used for Sorted Array: " + totalMemory_Sorted / 10 + " bytes");
        System.out.println();

        // Random
        long totalTime_Random = 0;
        long totalMemory_Random = 0;
        long totalLength_Random = 0;

        for (int i = 1; i <= 10; i++) {
            int[] A2 = getRandomArray();
            System.out.println("Length of the array " + i + ": " + A2.length);
            totalLength_Random += A2.length;

            Runtime runtime = Runtime.getRuntime();
            runtime.gc();
            long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
            
            long timeStart = System.nanoTime();

            // change the sort
            combSort(A2);
    
            long timeEnd = System.nanoTime();

            long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

            long memoryUsed = memoryAfter - memoryBefore;
            long duration = timeEnd - timeStart;

            totalTime_Random += duration;
            System.out.println("totalTime: " + totalTime_Random);
            totalMemory_Random += memoryUsed;
            
        }

        System.out.println("Average length for Random Array: " + totalLength_Random / 10);
        System.out.println("Execution Time for Random Array: " + totalTime_Random / 10 + " ns");
        System.out.println("Memory Used for Random Array: " + totalMemory_Random / 10 + " bytes");
        System.out.println();

        // Reverse
        long totalTime_Reverse = 0;
        long totalMemory_Reverse = 0;
        long totalLength_Reverse = 0;

        for (int i = 1; i <= 5; i++) {
            int[] A3 = getReverseArray();
            System.out.println("Length of the array " + i + ": " + A3.length);
            totalLength_Reverse += A3.length;

            Runtime runtime = Runtime.getRuntime();
            runtime.gc();
            long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
            
            long timeStart = System.nanoTime();

            // change the sort
            combSort(A3);
    
            long timeEnd = System.nanoTime();

            long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

            long memoryUsed = memoryAfter - memoryBefore;
            long duration = timeEnd - timeStart;

            totalTime_Reverse += duration;
            System.out.println("totalTime: " + totalTime_Reverse);
            totalMemory_Reverse += memoryUsed;
            
        }

        System.out.println("Average length for Reversed Array: " + totalLength_Reverse / 5);
        System.out.println("Execution Time for Reversed Array: " + totalTime_Reverse / 5 + " ns");
        System.out.println("Memory Used for Reversed Array: " + totalMemory_Reverse / 5 + " bytes");
        System.out.println();

        // Partially sorted
        long totalTime_Partially = 0;
        long totalMemory_Partially = 0;
        long totalLength_Partially = 0;

        for (int i = 1; i <= 10; i++) {
            int[] A4 = getPartiallySortedArray();
            System.out.println("Length of the array " + i + ": " + A4.length);
            totalLength_Partially += A4.length;

            Runtime runtime = Runtime.getRuntime();
            runtime.gc();
            long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
            
            long timeStart = System.nanoTime();

            // change the sort
            combSort(A4);
    
            long timeEnd = System.nanoTime();

            long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

            long memoryUsed = memoryAfter - memoryBefore;
            long duration = timeEnd - timeStart;

            totalTime_Partially += duration;
            System.out.println("totalTime: " + totalTime_Partially);
            totalMemory_Partially += memoryUsed;
            
        }

        System.out.println("Average length for Partially Sorted Array: " + totalLength_Partially / 10);
        System.out.println("Execution Time for Partially Sorted Array: " + totalTime_Partially / 10 + " ns");
        System.out.println("Memory Used for Partially Sorted Array: " + totalMemory_Partially / 10 + " bytes");
        System.out.println();
    }



    // the sorting algorithm that already implemented
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

    public static void main(String[] args) {
        test();
    }
}