class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int currSum = 0;
        // loop over the array with sliding window
        for(; right<nums.length; right++) {
            currSum = currSum + nums[right];
            // take the length and shorten the windown from left
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