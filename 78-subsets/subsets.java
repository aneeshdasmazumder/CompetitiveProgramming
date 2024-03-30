class Solution {
    List<List<Integer>> Ans = new ArrayList<>();
    int n;

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> op = new ArrayList<>();
        n = nums.length;

        // call the helper function
        Helper(op, nums, 0);

        return Ans;
    }

    public void Helper(List<Integer> op, int[] nums, int startIndex) {
        // base case
        if (startIndex == n) {
            Ans.add(new ArrayList<>(op));
            return;
        }

        // recursive case
        // choice 1: include the current element
        op.add(nums[startIndex]);
        Helper(op, nums, startIndex + 1);

        // backtracking step
        op.remove(op.size() - 1);

        // choice 2: exclude the current element
        Helper(op, nums, startIndex + 1);
    }
}