import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveElement {
    /*
    Question:
    Given an integer array nums and an integer val, remove all occurrences of val
    in-place. The order of the remaining elements may be changed.

    Return k, the number of elements in nums that are not equal to val.

    Constraints:
    0 <= nums.length <= 100
    0 <= nums[i] <= 50
    0 <= val <= 100

    Example Test Cases:
    1. Input: nums = [3, 2, 2, 3], val = 3
       Output: 2, nums first 2 elements contain [2, 2]

    2. Input: nums = [0, 1, 2, 2, 3, 0, 4, 2], val = 2
       Output: 5, nums first 5 elements contain [0, 0, 1, 3, 4]
    */
    public static int removeElement(int[] nums, int val) {
        // Write your solution here.
        int k = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == val) {
                nums[i] = -1;
            } else k += 1;
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == -1) {
                for(int j=i+1; j<nums.length; j++) {
                    if(nums[j] != -1) {
                        nums[i] = nums[j];
                        nums[j] = -1;
                        break;
                    }
                }
            }
        }
        return k;
    }

    public static void main(String[] args) {
        List<TestCase> testCases = new ArrayList<>();

        addTest(testCases, new int[] {3, 2, 2, 3}, 3);
        addTest(testCases, new int[] {0, 1, 2, 2, 3, 0, 4, 2}, 2);
        addTest(testCases, new int[] {}, 0);
        addTest(testCases, new int[] {1}, 1);
        addTest(testCases, new int[] {1}, 2);
        addTest(testCases, new int[] {1, 1, 1}, 1);
        addTest(testCases, new int[] {1, 2, 3}, 4);
        addTest(testCases, new int[] {4, 5}, 4);
        addTest(testCases, new int[] {-1, -2, -1, 0}, -1);
        addTest(testCases, new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0}, Integer.MIN_VALUE);
        addTest(testCases, new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE}, Integer.MAX_VALUE);
        addTest(testCases, new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE}, Integer.MAX_VALUE);
        addTest(testCases, new int[] {0, 0, 0, 0}, 0);
        addTest(testCases, new int[] {0, 0, 0, 0}, 1);
        addTest(testCases, new int[] {-5, -4, -3, -2, -1}, -3);
        addTest(testCases, new int[] {-5, -4, -3, -2, -1}, 10);
        addTest(testCases, new int[] {5, 4, 3, 2, 1}, 3);
        addTest(testCases, new int[] {1, 2, 3, 4, 5}, 3);
        addTest(testCases, new int[] {7, 7, 1, 2, 3}, 7);
        addTest(testCases, new int[] {1, 2, 3, 7, 7}, 7);
        addTest(testCases, new int[] {7, 1, 7, 2, 7, 3, 7}, 7);
        addTest(testCases, new int[] {-1, 0, 1, -1, 0, 1}, 0);
        addTest(testCases, new int[] {100000, -100000, 100000, -100000}, 100000);
        addTest(testCases, new int[] {Integer.MAX_VALUE, 0, Integer.MIN_VALUE, 0}, 0);
        addTest(testCases, new int[] {2, 2, 3, 3, 4, 4}, 3);
        addTest(testCases, new int[] {2, 3, 2, 3, 2, 3}, 2);
        addTest(testCases, new int[] {9, 8, 7, 6, 5, 4, 3}, 9);
        addTest(testCases, new int[] {9, 8, 7, 6, 5, 4, 3}, 3);
        addTest(testCases, new int[] {-2, -2, -2, 5, 5, 5}, 5);
        addTest(testCases, new int[] {-2, -2, -2, 5, 5, 5}, -2);

        for (int length = 0; length <= 30; length++) {
            int val = (length % 7) - 3;
            addTest(testCases, alternatingValueArray(length, val), val);
            addTest(testCases, ascendingAroundValueArray(length, val), val);
            addTest(testCases, descendingAroundValueArray(length, val), val);
        }

        int passed = 0;

        for (int i = 0; i < testCases.size(); i++) {
            if (runTest(i + 1, testCases.get(i))) {
                passed++;
            }
        }

        System.out.println();
        System.out.println("Passed " + passed + " out of " + testCases.size() + " test cases.");
    }

    private static void addTest(List<TestCase> testCases, int[] nums, int val) {
        testCases.add(new TestCase(nums, val));
    }

    private static int[] alternatingValueArray(int length, int val) {
        int[] nums = new int[length];

        for (int i = 0; i < length; i++) {
            nums[i] = i % 2 == 0 ? val : i - 15;
        }

        return nums;
    }

    private static int[] ascendingAroundValueArray(int length, int val) {
        int[] nums = new int[length];

        for (int i = 0; i < length; i++) {
            nums[i] = i % 5 == 0 ? val : i - 10;
        }

        return nums;
    }

    private static int[] descendingAroundValueArray(int length, int val) {
        int[] nums = new int[length];

        for (int i = 0; i < length; i++) {
            nums[i] = i % 4 == 0 ? val : 10 - i;
        }

        return nums;
    }

    private static boolean runTest(int testNumber, TestCase testCase) {
        int[] input = testCase.nums;
        int val = testCase.val;
        int[] expectedNums = buildExpected(input, val);
        int[] nums = Arrays.copyOf(input, input.length);
        int k = removeElement(nums, val);

        Arrays.sort(nums, 0, k);

        boolean passed = k == expectedNums.length;

        for (int i = 0; i < k && passed; i++) {
            if (nums[i] != expectedNums[i]) {
                passed = false;
            }
        }

        if (!passed) {
            System.out.println("Test " + testNumber + " failed");
            System.out.println("Input:    nums = " + Arrays.toString(input) + ", val = " + val);
            System.out.println("Expected: k = " + expectedNums.length
                    + ", first k = " + Arrays.toString(expectedNums));
            System.out.println("Actual:   k = " + k
                    + ", first k = " + Arrays.toString(Arrays.copyOf(nums, k)));
            System.out.println();
        }

        return passed;
    }

    private static int[] buildExpected(int[] nums, int val) {
        int count = 0;

        for (int num : nums) {
            if (num != val) {
                count++;
            }
        }

        int[] expected = new int[count];
        int idx = 0;

        for (int num : nums) {
            if (num != val) {
                expected[idx] = num;
                idx++;
            }
        }

        Arrays.sort(expected);
        return expected;
    }

    private static class TestCase {
        private final int[] nums;
        private final int val;

        private TestCase(int[] nums, int val) {
            this.nums = nums;
            this.val = val;
        }
    }
}
