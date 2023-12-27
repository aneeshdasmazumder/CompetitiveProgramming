class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;

        while(left < nums.length - 1 && right < nums.length - 1) {
            if(nums[left] == 0) {
                right = left + 1;
                while(right < nums.length && nums[right] ==0) {
                    right++;
                }
                if(right < nums.length) {
                    int temp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = temp;
                }
                
            }

            left++;
        }
    }
}