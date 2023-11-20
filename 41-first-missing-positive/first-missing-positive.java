class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0; i<nums.length; i++) {

            while(nums[i]-1 != i && nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
            System.out.println(nums[i]);
        }

        int val = Integer.MAX_VALUE;

        int count = 1;
        int idx = 0;
        while(idx < nums.length && nums[idx] == count) {
            idx++;
            count++;
        }
            return count;
    }
}