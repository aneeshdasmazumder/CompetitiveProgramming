class Solution {
    
    public int[] productExceptSelf(int[] nums) {
        // int[] left = new int[nums.length];
        // int[] ans = new int[nums.length];

        // left[0] = 1;
        // for(int i=1; i<nums.length; i++) {
        //     left[i] = left[i-1] * nums[i-1];
        // }

        // ans[nums.length-1] = left[left.length-1];
        // int temp = 1;
        // for(int i=ans.length-2; i>=0; i--) {
        //     temp = temp * nums[i+1];
        //     ans[i] = temp * left[i];
        // }
        // return ans;

        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];

        // Prefix
        left[0] = nums[0];
        for(int i=1; i<n; i++) {
            left[i] = left[i-1] * nums[i];
        }

        // Suffix
        right[n-1] = nums[n-1];

        for(int i=n-2; i>=0; i--) {
            right[i] = right[i+1] * nums[i];
        }

        ans[0] = right[1];
        ans[n-1] = left[n-2];

        for(int i=n-2; i>0; i--) {
            ans[i] = left[i-1] * right[i+1];
        }

        return ans;
    }
}