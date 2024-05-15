class Solution {
    public void sortColors(int[] nums) {
        final int n = nums.length;
        int zero = 0, index = 0, two = n - 1;

        while(index <= two)
            if(nums[index] == 0)
                swap(nums, index++, zero++);
            else if(nums[index] == 1)
                index++;
            else
                swap(nums, index, two--);
    }

    private void swap(final int[] nums, final int idx1, final int idx2) {
        final int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}