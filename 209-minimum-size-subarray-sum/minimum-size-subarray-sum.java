class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int currSum = 0;

        for(; right<nums.length; right++) {
            currSum = currSum + nums[right];
            while (currSum >= target) {
                int len = (right - left) + 1;

                minLen = Math.min(minLen, len);
                currSum -= nums[left];
                left++;
            }
            
        }

        if(minLen == Integer.MAX_VALUE)
            return 0;
        else return minLen;
    }
}