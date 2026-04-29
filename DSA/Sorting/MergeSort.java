public class MergeSort {
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = (left + right)/2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = (mid - left) + 1;
        int n2 = (right - mid);

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i=0; i<n1; i++) {
            L[i] = arr[left + i];
        }

        for(int i=0; i<n2; i++) {
            R[i] = arr[mid + i + 1];
        }
        int i=0, j=0, idx = left;
        while(i < n1 && j < n2) {
            if(L[i] < R[j]) {
                arr[idx] = L[i];
                idx++; i++;
            } else {
                arr[idx] = R[j];
                idx++; j++;
            }
        }
        
        while(i<n1) {
            arr[idx] = L[i];
            idx++; i++;
        }

        while(j<n2) {
            arr[idx] = R[j];
            idx++; j++;
        }
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {2, 1, 6, 10, 4, 1, 3, 9, 7},
            {5, 1, 4, 2, 8},
            {1, 2, 3, 4, 5},
            {9, -3, 0, 7, 7},
            {},
            {1},
            {2, 1},
            {1, 2},
            {1, 1},
            {-1, -2},
            {0, 0, 0},
            {3, 3, 2, 2, 1, 1},
            {10, 9, 8, 7, 6, 5},
            {-5, -4, -3, -2, -1},
            {-1, -2, -3, -4, -5},
            {-10, 0, 10},
            {100000, -100000},
            {100000, 99999, -99999, -100000},
            {4, 1, 3, 9, 7},
            {64, 34, 25, 12, 22, 11, 90},
            {5, 4, 3, 2, 1},
            {1, 3, 2, 4, 5},
            {2, 1, 3, 4, 5},
            {1, 2, 3, 5, 4},
            {5, 1, 2, 3, 4},
            {2, 3, 4, 5, 1},
            {8, 8, 8, 1, 8},
            {1, 8, 8, 8, 8},
            {8, 8, 8, 8, 1},
            {-3, 14, -1, 0, 7, -8, 14},
            {12, -12, 12, -12, 0},
            {Integer.MAX_VALUE, Integer.MIN_VALUE},
            {Integer.MAX_VALUE, 0, Integer.MIN_VALUE},
            {42, -7, 19, 0, 42, -7},
            {6, 5, 4, 3, 2, 1, 0, -1},
            {-1, 0, 1, -1, 0, 1},
            {3, 1, 2},
            {2, 3, 1},
            {1, 3, 2},
            {3, 2, 1},
            {1, 1, 2, 2, 3, 3},
            {3, 3, 2, 2, 1, 1},
            {7, 0, -7, 14, -14, 21, -21},
            {50, 40, 30, 20, 10, 0, -10},
            {-100000, 100000, 0, -99999, 99999},
            {11, 13, 17, 19, 23, 29},
            {29, 23, 19, 17, 13, 11},
            {4, 2, 4, 2, 4, 2},
            {0, -1, -1, -2, -2, -3},
            {100, 1, 99, 2, 98, 3, 97},
            {9, 1, 8, 2, 7, 3, 6, 4, 5},
            {31, 41, 59, 26, 53, 58, 97, 93},
            {-50, -10, -20, -30, -40},
            {5, -1, 5, -1, 5, -1, 0},
            {16, 15, 14, 1, 2, 3},
            {2, 2, 2, 2, 1},
            {1, 2, 2, 2, 2},
            {100000, 100000, -100000, -100000, 0},
            {13, -13, 26, -26, 39, -39, 0},
            {6, 1, 6, 2, 6, 3, 6, 4},
            {10, -10, 9, -9, 8, -8, 7, -7},
            {1, 0, -1, 0, 1, 0, -1},
            {22, 11, 0, -11, -22, 33, -33}
        };

        int passed = 0;

        for (int i = 0; i < testCases.length; i++) {
            int[] actual = java.util.Arrays.copyOf(testCases[i], testCases[i].length);
            int[] expected = java.util.Arrays.copyOf(testCases[i], testCases[i].length);

            mergeSort(actual);
            java.util.Arrays.sort(expected);

            boolean isPassed = java.util.Arrays.equals(actual, expected);

            if (isPassed) {
                passed++;
            } else {
                System.out.println("Test " + (i + 1) + " failed");
                System.out.println("Input:    " + java.util.Arrays.toString(testCases[i]));
                System.out.println("Expected: " + java.util.Arrays.toString(expected));
                System.out.println("Actual:   " + java.util.Arrays.toString(actual));
                System.out.println();
            }
        }

        System.out.println();
        System.out.println("Passed " + passed + " out of " + testCases.length + " test cases.");
    }
}
