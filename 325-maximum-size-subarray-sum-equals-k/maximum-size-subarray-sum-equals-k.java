class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int currSum = 0;
        // loop over the array
        for(int i=0; i<nums.length; i++) {
            // calculate the curr sum one after another
            currSum += nums[i];

            // 1. If currSum matches the k, then calculate the maxLen
            if(currSum == k) maxLen = i + 1;
            // 2. If totalSumof the array - given value present in the map then get maxLen
            else if(map.containsKey(currSum - k)) {
                maxLen = Math.max(maxLen, i - map.get(currSum - k));
            }
            // If the currSum not present store it with index
            if(!map.containsKey(currSum))
                map.put(currSum, i);
        }

        return maxLen;
    }
}