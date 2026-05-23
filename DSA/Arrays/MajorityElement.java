import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than floor(n / 2) times.
You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3, 2, 3]
Output: 3

Example 2:
Input: nums = [2, 2, 1, 1, 1, 2, 2]
Output: 2

Constraints:
n == nums.length
1 <= n <= 5 * 10^4
-10^9 <= nums[i] <= 10^9
The input is generated such that a majority element will exist in the array.
*/
public class MajorityElement {
    private static final int MIN_NUM = -1_000_000_000;
    private static final int MAX_NUM = 1_000_000_000;
    private static final int PERFORMANCE_LENGTH = 50_000;
    private static final long PERFORMANCE_LIMIT_MS = 250;

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length/2];
    }

    public static void main(String[] args) throws InterruptedException {
        List<TestCase> testCases = new ArrayList<>();

        addTest(testCases, new int[] {3, 2, 3});
        addTest(testCases, new int[] {2, 2, 1, 1, 1, 2, 2});
        addTest(testCases, new int[] {1});
        addTest(testCases, new int[] {1, 1});
        addTest(testCases, new int[] {1, 2, 1});
        addTest(testCases, new int[] {2, 1, 2});
        addTest(testCases, new int[] {2, 2, 1});
        addTest(testCases, new int[] {0, 0, 0});
        addTest(testCases, new int[] {-1, -1, -1});
        addTest(testCases, new int[] {-1, 2, -1});
        addTest(testCases, new int[] {MIN_NUM, MIN_NUM, MAX_NUM});
        addTest(testCases, new int[] {MAX_NUM, MIN_NUM, MAX_NUM});
        addTest(testCases, new int[] {7, 7, 7, 7});
        addTest(testCases, new int[] {9, 9, 9, 1, 2});
        addTest(testCases, new int[] {1, 2, 9, 9, 9});
        addTest(testCases, new int[] {9, 1, 9, 2, 9});
        addTest(testCases, new int[] {-5, -5, 1, -5, 2});
        addTest(testCases, new int[] {4, 4, 4, 4, 1, 2, 3});
        addTest(testCases, new int[] {1, 2, 3, 4, 4, 4, 4});
        addTest(testCases, new int[] {4, 1, 4, 2, 4, 3, 4});
        addTest(testCases, new int[] {10, 10, 10, 10, 10, -1, -2, -3, -4});
        addTest(testCases, new int[] {-10, 5, -10, 6, -10, 7, -10});
        addTest(testCases, new int[] {0, 1, 0, 2, 0, 3, 0, 4, 0});
        addTest(testCases, new int[] {100, 100, -100, 100, -100, 100, 100});
        addTest(testCases, new int[] {8, 8, 8, 8, 8, 8, 1, 2, 3, 4, 5});
        addTest(testCases, new int[] {6, 1, 6, 2, 6, 3, 6, 4, 6, 5, 6});
        addTest(testCases, new int[] {-3, -3, -3, -3, 4, 5, 6});
        addTest(testCases, new int[] {11, 12, 11, 13, 11, 14, 11, 15, 11});
        addTest(testCases, new int[] {42, 42, 42, 42, 42, 42, 42, 1});
        addTest(testCases, new int[] {-42, 1, -42, 2, -42, 3, -42, 4, -42});

        for (int length = 1; length <= 30; length++) {
            int majority = (length % 11) - 5;
            addTest(testCases, generateMajorityArray(length, majority, 100 + length, 0));
            addTest(testCases, generateMajorityArray(length, -majority, -100 - length, 1));
            addTest(testCases, generateMajorityArray(length, majority + 50, length * 3, 2));
        }

        int passed = 0;

        for (int i = 0; i < testCases.size(); i++) {
            if (runTest(i + 1, testCases.get(i))) {
                passed++;
            }
        }

        boolean correctnessPassed = passed == testCases.size();
        boolean performancePassed = false;

        if (correctnessPassed) {
            performancePassed = runPerformanceCheck();
        } else {
            System.out.println("Performance check skipped because correctness tests failed.");
        }

        System.out.println();
        System.out.println("Correctness: Passed " + passed + " out of " + testCases.size() + " test cases.");
        System.out.println("Performance: " + (performancePassed ? "Passed" : "Failed"));
        System.out.println("Overall: " + (correctnessPassed && performancePassed ? "Passed" : "Failed"));
    }

    private static void addTest(List<TestCase> testCases, int[] nums) {
        testCases.add(new TestCase(nums));
    }

    private static int[] generateMajorityArray(int length, int majority, int fillerStart, int pattern) {
        int[] nums = new int[length];
        int majorityCount = length / 2 + 1;

        if (pattern == 1) {
            majorityCount = length;
        } else if (pattern == 2 && majorityCount < length) {
            majorityCount++;
        }

        for (int i = 0; i < majorityCount; i++) {
            nums[i] = majority;
        }

        for (int i = majorityCount; i < length; i++) {
            int filler = fillerStart + i;

            if (filler == majority) {
                filler++;
            }

            nums[i] = filler;
        }

        deterministicShuffle(nums, pattern + length);
        return nums;
    }

    private static void deterministicShuffle(int[] nums, int seed) {
        for (int i = 0; i < nums.length; i++) {
            int swapIdx = (i * 37 + seed * 11) % nums.length;
            swap(nums, i, swapIdx);
        }
    }

    private static void swap(int[] nums, int firstIdx, int secondIdx) {
        int temp = nums[firstIdx];
        nums[firstIdx] = nums[secondIdx];
        nums[secondIdx] = temp;
    }

    private static boolean runTest(int testNumber, TestCase testCase) {
        int[] input = testCase.nums;

        if (!isValidInput(input)) {
            System.out.println("Test " + testNumber + " is invalid for the stated constraints.");
            System.out.println("Input: " + Arrays.toString(input));
            System.out.println();
            return false;
        }

        int expected = buildExpected(input);
        int actual = majorityElement(Arrays.copyOf(input, input.length));
        boolean passed = actual == expected;

        if (!passed) {
            System.out.println("Test " + testNumber + " failed");
            System.out.println("Input:    " + Arrays.toString(input));
            System.out.println("Expected: " + expected);
            System.out.println("Actual:   " + actual);
            System.out.println();
        }

        return passed;
    }

    private static boolean runPerformanceCheck() throws InterruptedException {
        int[] input = generateMajorityArray(PERFORMANCE_LENGTH, 123_456_789, -500_000, 2);
        int expected = buildExpected(input);
        int[] actual = new int[1];
        Throwable[] failure = new Throwable[1];

        Thread worker = new Thread(() -> {
            try {
                actual[0] = majorityElement(Arrays.copyOf(input, input.length));
            } catch (Throwable throwable) {
                failure[0] = throwable;
            }
        }, "majority-element-performance-check");

        worker.setDaemon(true);

        long start = System.nanoTime();
        worker.start();
        worker.join(PERFORMANCE_LIMIT_MS);
        long elapsedMs = (System.nanoTime() - start) / 1_000_000;

        if (worker.isAlive()) {
            System.out.println("Performance check failed");
            System.out.println("Input length: " + PERFORMANCE_LENGTH);
            System.out.println("Limit:        " + PERFORMANCE_LIMIT_MS + " ms");
            System.out.println("Result:       Method did not finish in time.");
            return false;
        }

        if (failure[0] != null) {
            System.out.println("Performance check failed");
            System.out.println("Reason: " + failure[0].getClass().getSimpleName() + " - " + failure[0].getMessage());
            return false;
        }

        if (actual[0] != expected) {
            System.out.println("Performance check failed");
            System.out.println("Expected: " + expected);
            System.out.println("Actual:   " + actual[0]);
            return false;
        }

        System.out.println("Performance check passed in " + elapsedMs + " ms.");
        return true;
    }

    private static boolean isValidInput(int[] nums) {
        if (nums.length < 1 || nums.length > PERFORMANCE_LENGTH) {
            return false;
        }

        for (int num : nums) {
            if (num < MIN_NUM || num > MAX_NUM) {
                return false;
            }
        }

        buildExpected(nums);
        return true;
    }

    private static int buildExpected(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }

        throw new IllegalArgumentException("Input does not contain a majority element.");
    }

    private static class TestCase {
        private final int[] nums;

        private TestCase(int[] nums) {
            this.nums = nums;
        }
    }
}
