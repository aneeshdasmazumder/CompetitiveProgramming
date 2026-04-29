import java.util.Arrays;

/*
Question:
Given an integer array, sort the array in ascending order using Insertion Sort.

Insertion Sort builds the sorted array one element at a time. For each element,
it shifts larger elements in the sorted left portion one position to the right,
then inserts the current element into its correct position.

Time Complexity:
Best Case: O(n) when the array is already sorted.
Average Case: O(n^2)
Worst Case: O(n^2)

Space Complexity:
O(1), because Insertion Sort sorts the array in place.

Constraints:
1 <= n <= 10^3
-10^5 <= arr[i] <= 10^5

Example Test Cases:
1. Input:  [5, 1, 4, 2, 8]
   Output: [1, 2, 4, 5, 8]

2. Input:  [1, 2, 3, 4, 5]
   Output: [1, 2, 3, 4, 5]

3. Input:  [9, -3, 0, 7, 7]
   Output: [-3, 0, 7, 7, 9]
*/
public class InsertionSort {
    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void insertionSort(int[] arr) {
        for(int i=0; i<arr.length - 1; i++) {
            int j = i+1;
            int tempIdx = j;
            int temp = arr[tempIdx];
            int x = i;
            while (j >0 && temp <= arr[j-1]) { 
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[][] testCases = {
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
            if (runTest(i + 1, testCases[i])) {
                passed++;
            }
        }

        System.out.println();
        System.out.println("Passed " + passed + " out of " + testCases.length + " test cases.");
    }

    private static boolean runTest(int testNumber, int[] input) {
        int[] actual = Arrays.copyOf(input, input.length);
        int[] expected = Arrays.copyOf(input, input.length);

        insertionSort(actual);
        Arrays.sort(expected);

        boolean passed = Arrays.equals(actual, expected);

        if (!passed) {
            System.out.println("Test " + testNumber + " failed");
            System.out.println("Input:    " + Arrays.toString(input));
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Actual:   " + Arrays.toString(actual));
            System.out.println();
        }

        return passed;
    }
}
