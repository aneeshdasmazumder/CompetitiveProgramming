/*
Question:
Given two sorted integer arrays, merge them into one sorted array.

The merged array should contain all elements from both input arrays in
ascending order.

Time Complexity:
O(n + m), where n and m are the lengths of the two arrays.

Space Complexity:
O(n + m), because a new merged array is created.

Constraints:
0 <= arr1.length, arr2.length <= 10^3
-10^5 <= arr1[i], arr2[i] <= 10^5

Example Test Cases:
1. Input:  arr1 = [1, 3, 5], arr2 = [2, 4, 6]
   Output: [1, 2, 3, 4, 5, 6]

2. Input:  arr1 = [1, 2, 3], arr2 = []
   Output: [1, 2, 3]

3. Input:  arr1 = [-3, 0, 7], arr2 = [-2, 4, 8]
   Output: [-3, -2, 0, 4, 7, 8]
*/
public class Merge2Arrays {
    public static int[] merge2Arrays(int[] arr1, int[] arr2) {
        int arr1Idx = arr1.length;
        int arr2Idx = arr2.length;

        int n = arr1Idx + arr2Idx;

        int[] newArr = new int[n];

        int newIdx = 0;
        for(int i=0; i<arr1Idx; i++) {
            newArr[newIdx] = arr1[i];
            newIdx++;
        }

        for(int i=0; i<arr2Idx; i++) {
            newArr[newIdx] = arr2[i];
            newIdx++;
        }

        quickSort(newArr, 0, newArr.length-1);

        return newArr;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = low;

        while(low < arr.length && high >=0 && low < high) {
            while(low < arr.length && arr[low] <= arr[pivot]) low++;
            while(high >=0 && arr[high] > arr[pivot]) high--;

            if(low < high) swap(arr, low, high);
        }

        swap(arr, pivot, high);

        return high;
    }

    public static void swap(int[] arr, int firstIdx, int secondIdx) {
        int temp = arr[firstIdx];
        arr[firstIdx] = arr[secondIdx];
        arr[secondIdx] = temp;
    }

    public static void main(String[] args) {
        int[][] arr1TestCases = {
            {1, 3, 5},
            {1, 2, 3},
            {},
            {-3, 0, 7},
            {1},
            {},
            {1, 1, 1},
            {-5, -3, -1},
            {0, 2, 4, 6},
            {Integer.MIN_VALUE, 0, Integer.MAX_VALUE},
            {-10, -5, 0, 5},
            {2, 4, 6, 8},
            {1, 2, 2, 4},
            {100000},
            {-100000, -99999}
        };

        int[][] arr2TestCases = {
            {2, 4, 6},
            {},
            {4, 5, 6},
            {-2, 4, 8},
            {2},
            {},
            {1, 1},
            {-4, -2, 0},
            {1, 3, 5, 7},
            {Integer.MIN_VALUE, Integer.MAX_VALUE},
            {-7, -3, 3, 9},
            {1, 3, 5, 7},
            {2, 2, 3},
            {-100000},
            {99999, 100000}
        };

        int passed = 0;

        for (int i = 0; i < arr1TestCases.length; i++) {
            int[] actual = merge2Arrays(arr1TestCases[i], arr2TestCases[i]);
            int[] expected = buildExpected(arr1TestCases[i], arr2TestCases[i]);

            boolean isPassed = java.util.Arrays.equals(actual, expected);

            if (isPassed) {
                passed++;
            } else {
                System.out.println("Test " + (i + 1) + " failed");
                System.out.println("Arr1:     " + java.util.Arrays.toString(arr1TestCases[i]));
                System.out.println("Arr2:     " + java.util.Arrays.toString(arr2TestCases[i]));
                System.out.println("Expected: " + java.util.Arrays.toString(expected));
                System.out.println("Actual:   " + java.util.Arrays.toString(actual));
                System.out.println();
            }
        }

        System.out.println();
        System.out.println("Passed " + passed + " out of " + arr1TestCases.length + " test cases.");
    }

    private static int[] buildExpected(int[] arr1, int[] arr2) {
        int[] expected = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            expected[i] = arr1[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            expected[arr1.length + i] = arr2[i];
        }

        java.util.Arrays.sort(expected);
        return expected;
    }
}
