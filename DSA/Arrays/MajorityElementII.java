import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/*
Given an integer array of size n, find all elements that appear more than
floor(n / 3) times.

Example 1:
Input: nums = [3, 2, 3]
Output: [3]

Example 2:
Input: nums = [1]
Output: [1]

Example 3:
Input: nums = [1, 2]
Output: [1, 2]

Constraints:
1 <= nums.length <= 5 * 10^4
-10^9 <= nums[i] <= 10^9
*/
public class MajorityElementII {
    private static final int MIN_NUM = -1_000_000_000;
    private static final int MAX_NUM = 1_000_000_000;
    private static final int PERFORMANCE_LENGTH = 50_000;
    private static final long PERFORMANCE_LIMIT_MS = 350;

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        Map<Integer, Integer> majorityCountTable = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(!majorityCountTable.containsKey(nums[i])) {
                majorityCountTable.put(nums[i], 1);
            } else {
                majorityCountTable.put(nums[i], majorityCountTable.get(nums[i]) + 1);
            }
        }

        majorityCountTable.forEach((key, value) -> {
            if(value > nums.length/3) result.add(key);
        });

        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        List<TestCase> testCases = new ArrayList<>();

        addTest(testCases, new int[] {3, 2, 3});
        addTest(testCases, new int[] {1});
        addTest(testCases, new int[] {1, 2});
        addTest(testCases, new int[] {1, 1, 1});
        addTest(testCases, new int[] {1, 2, 3});
        addTest(testCases, new int[] {1, 1, 2, 2, 3});
        addTest(testCases, new int[] {1, 1, 1, 2, 3, 4});
        addTest(testCases, new int[] {1, 2, 2, 2, 3, 4});
        addTest(testCases, new int[] {1, 1, 1, 2, 2, 2, 3});
        addTest(testCases, new int[] {0, 0, 0, 1, 2});
        addTest(testCases, new int[] {-1, -1, -1, 2, 3});
        addTest(testCases, new int[] {-1, -1, 2, 2, 3});
        addTest(testCases, new int[] {MIN_NUM});
        addTest(testCases, new int[] {MAX_NUM});
        addTest(testCases, new int[] {MIN_NUM, MAX_NUM});
        addTest(testCases, new int[] {MIN_NUM, MIN_NUM, MAX_NUM});
        addTest(testCases, new int[] {MAX_NUM, MAX_NUM, MIN_NUM});
        addTest(testCases, new int[] {MIN_NUM, MIN_NUM, MAX_NUM, MAX_NUM, 0});
        addTest(testCases, new int[] {7, 7, 7, 7, 7});
        addTest(testCases, new int[] {7, 7, 8, 8, 9, 9});
        addTest(testCases, new int[] {4, 4, 4, 5, 5, 6, 7, 8});
        addTest(testCases, new int[] {4, 5, 4, 5, 4, 5, 6, 7});
        addTest(testCases, new int[] {10, 10, 10, 20, 20, 20, 30, 40});
        addTest(testCases, new int[] {-5, -5, -5, -5, 2, 3, 4, 5, 6});
        addTest(testCases, new int[] {-5, 2, -5, 3, -5, 4, -5, 5, 6});
        addTest(testCases, new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1});
        addTest(testCases, new int[] {1, 2, 1, 2, 1, 2, 3, 4, 5});
        addTest(testCases, new int[] {100, 100, 100, 100, -100, -100, -100, -100, 0, 1});
        addTest(testCases, new int[] {0, 1, 0, 2, 0, 3, 0, 4, 0, 5});
        addTest(testCases, new int[] {11, 12, 11, 13, 11, 14, 11, 15, 16, 17});

        for (int length = 1; length <= 35; length++) {
            addTest(testCases, generateCase(length, length % 17 - 8, 100 + length, 0));
            addTest(testCases, generateCase(length, length % 19 - 9, -100 - length, 1));
            addTest(testCases, generateCase(length, 50 + length, -50 - length, 2));
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

    private static int[] generateCase(int length, int firstMajor, int fillerStart, int pattern) {
        int[] nums = new int[length];
        int idx = 0;
        int threshold = length / 3;
        int firstCount = Math.min(length, threshold + 1);
        int secondMajor = firstMajor + 1;

        if (secondMajor == fillerStart) {
            secondMajor++;
        }

        int secondCount = 0;

        if (pattern == 1 && length - firstCount > threshold) {
            secondCount = threshold + 1;
        } else if (pattern == 2) {
            firstCount = 0;
        }

        for (int i = 0; i < firstCount && idx < length; i++) {
            nums[idx] = firstMajor;
            idx++;
        }

        for (int i = 0; i < secondCount && idx < length; i++) {
            nums[idx] = secondMajor;
            idx++;
        }

        int filler = fillerStart;

        while (idx < length) {
            if (filler == firstMajor || filler == secondMajor) {
                filler++;
            }

            nums[idx] = filler;
            idx++;
            filler++;
        }

        deterministicShuffle(nums, pattern + length);
        return nums;
    }

    private static void deterministicShuffle(int[] nums, int seed) {
        for (int i = 0; i < nums.length; i++) {
            int swapIdx = (i * 41 + seed * 13) % nums.length;
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

        List<Integer> expected = buildExpected(input);
        List<Integer> actual = majorityElement(Arrays.copyOf(input, input.length));
        boolean passed = sameValues(actual, expected);

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
        int[] input = buildPerformanceInput();
        List<Integer> expected = buildExpected(input);
        AtomicReference<List<Integer>> actual = new AtomicReference<>();
        Throwable[] failure = new Throwable[1];

        Thread worker = new Thread(() -> {
            try {
                actual.set(majorityElement(Arrays.copyOf(input, input.length)));
            } catch (Throwable throwable) {
                failure[0] = throwable;
            }
        }, "majority-element-ii-performance-check");

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

        if (!sameValues(actual.get(), expected)) {
            System.out.println("Performance check failed");
            System.out.println("Expected: " + expected);
            System.out.println("Actual:   " + actual.get());
            return false;
        }

        System.out.println("Performance check passed in " + elapsedMs + " ms.");
        return true;
    }

    private static int[] buildPerformanceInput() {
        int[] nums = new int[PERFORMANCE_LENGTH];
        int firstMajor = 111_111_111;
        int secondMajor = -222_222_222;
        int firstCount = PERFORMANCE_LENGTH / 3 + 2;
        int secondCount = PERFORMANCE_LENGTH / 3 + 1;
        int idx = 0;

        for (int i = 0; i < firstCount; i++) {
            nums[idx] = firstMajor;
            idx++;
        }

        for (int i = 0; i < secondCount; i++) {
            nums[idx] = secondMajor;
            idx++;
        }

        int filler = -500_000;

        while (idx < nums.length) {
            if (filler == firstMajor || filler == secondMajor) {
                filler++;
            }

            nums[idx] = filler;
            idx++;
            filler++;
        }

        deterministicShuffle(nums, 97);
        return nums;
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

        return true;
    }

    private static List<Integer> buildExpected(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        List<Integer> expected = new ArrayList<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > nums.length / 3) {
                expected.add(entry.getKey());
            }
        }

        Collections.sort(expected);
        return expected;
    }

    private static boolean sameValues(List<Integer> actual, List<Integer> expected) {
        if (actual == null) {
            return expected.isEmpty();
        }

        List<Integer> actualSorted = new ArrayList<>(actual);
        Collections.sort(actualSorted);
        return actualSorted.equals(expected);
    }

    private static class TestCase {
        private final int[] nums;

        private TestCase(int[] nums) {
            this.nums = nums;
        }
    }
}
