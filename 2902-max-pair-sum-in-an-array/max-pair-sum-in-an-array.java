class Solution {
    public int maxSum(int[] nums) {
        int maxSum = 0;
        for(int i=0; i<nums.length-1; i++) {
            for(int j = i+1; j<nums.length; j++) {
                if(getMax(nums[i]) == getMax(nums[j])) {
                    maxSum = Math.max(maxSum, nums[i]+nums[j]);
                }
            }
        }
        if(maxSum > 0)
            return maxSum;
        return -1;
    }

    public int getMax(int a) {
        int max = 0;
        while (a != 0) {
            int rem = a%10;
            if(rem >= max)
                max = rem;
            a = a/10;
        }

        return max;
    }
}