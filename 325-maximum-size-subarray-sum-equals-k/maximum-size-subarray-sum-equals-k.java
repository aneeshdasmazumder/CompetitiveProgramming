class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int currSum = 0;

        for(int i=0; i<nums.length; i++) {
            currSum += nums[i];

            if(currSum == k) maxLen = i + 1;
            else if(map.containsKey(currSum - k)) {
                maxLen = Math.max(maxLen, i - map.get(currSum - k));
            }

            if(!map.containsKey(currSum))
                map.put(currSum, i);
        }

        return maxLen;
    }
}