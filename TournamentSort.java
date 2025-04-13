public class TournamentSort {
    public static void tournamentSort(int[] A) {
        int n = A.length;
        
        // find the next power of 2 greater than n
        int size = 1;
        while (size < n) size *= 2;

        int totalnodes = size * 2 - 1;
        int offset = size - 1;                              // to keep the start index of the leaf nodes
        int[] tree = new int[totalnodes];                   // binary tree for the tournament

        for (int i = 0; i < n; i++) {
            tree[offset + i] = A[i];                        // elements of A in the leaf nodes
        }

        for (int i = offset + n; i < totalnodes; i++) {     // if there is an empty leaf node, fill with the infinity value
            tree[i] = Integer.MAX_VALUE;
        }

        for (int i = offset - 1; i >= 0; i--) {             // deciding the first winner
            tree[i] = Math.min(tree[2 * i + 1], tree[2 * i + 2]);
        }

        for (int i = 0; i < n; i++) {
            A[i] = tree[0];                                 // always winner at the root

            int index = offset;
            while (index < totalnodes) {
                if (tree[index] == A[i]) {                  // find the winner's index
                    tree[index] = Integer.MAX_VALUE;        // replace with infinity
                    break;
                }
                index++;
            }

            int parent = (index - 1) / 2;

            while (parent >= 0) {                           // until the root
                int left = 2 * parent + 1;
                int right = 2 * parent + 2;
                tree[parent] = Math.min(tree[left], tree[right]);
                if (parent == 0) break;                     // reached the root and finished updating
                parent = (parent - 1) / 2;
            }
        }
    }
}













// time and space waste?

/* 
public class TournamentSort {
    public static void tournamentSort(int[] A) {
        int n = A.length;
        
        // find the next power of 2 greater than n
        int size = 1;
        while (size < n) size *= 2;

        int totalnodes = size * 2 - 1;
        int offset = size - 1;                              // to keep the start index of the leaf nodes
        int[] tree = new int[totalnodes];                   // binary tree for the tournament

        for (int i = 0; i < n; i++) {
            tree[offset + i] = A[i];                        // elements of A in the leaf nodes
        }

        for (int i = offset + n; i < totalnodes; i++) {     // if there is an empty leaf node, fill with the infinity value
            tree[i] = Integer.MAX_VALUE;
        }

        for (int i = offset - 1; i >= 0; i--) {             // deciding the first winner
            tree[i] = Math.min(tree[2 * i + 1], tree[2 * i + 2]);
        }

        int[] result = new int[n];

        for (int k = 0; k < n; k++) {
            result[k] = tree[0];                            // winner is always at the root
            int index = offset;

            while (index < totalnodes) {
                if (tree[index] == result[k]) {             // find the winner's index
                    tree[index] = Integer.MAX_VALUE;        // replace it with infinity
                    break;
                }
                index++;
            }

            int parent = (index - 1) / 2;

            while (parent >= 0) {                           // updating the tree
                int left = 2 * parent + 1;
                int right = 2 * parent + 2;
                tree[parent] = Math.min(tree[left], tree[right]);
                if (parent == 0) break;                     // reached the root and finished updating
                parent = (parent - 1) / 2;
            }
        }

        for (int i = 0; i < n; i++) {
            A[i] = result[i];
        }
    }

    // 테스트용 main 함수
    public static void main(String[] args) {
        int[] A = {9, 3, 1, 7, 4, 8, 2, 6, 5};
        tournamentSort(A);

        System.out.print("Sorted: ");
        for (int num : A) {
            System.out.print(num + " ");
        }
    }
}*/