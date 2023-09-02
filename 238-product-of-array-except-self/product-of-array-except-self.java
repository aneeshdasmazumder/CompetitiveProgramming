class Solution {
    
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] ans = new int[nums.length];

        left[0] = 1;
        for(int i=1; i<nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        ans[nums.length-1] = left[left.length-1];
        int temp = 1;
        for(int i=ans.length-2; i>=0; i--) {
            temp = temp * nums[i+1];
            ans[i] = temp * left[i];
        }
        return ans;
    }
}