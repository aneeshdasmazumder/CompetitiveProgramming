class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            int idx = Math.abs(nums[i]);
            if(nums[idx] >= 0) {
                nums[idx] = -nums[idx];
            } else {
                return idx;
            }
        }

        return -1;
    }
}