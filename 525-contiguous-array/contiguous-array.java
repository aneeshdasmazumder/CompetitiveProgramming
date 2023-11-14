class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int currSum =0;
        // Convert 0's to -1
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) nums[i] = -1;
        }

        // loop over the array
        for(int i=0; i<nums.length; i++) {
            currSum = currSum + nums[i];

            if(currSum == 0) maxLen = i+1;
            else if(map.containsKey(currSum)) {
                maxLen = Math.max(maxLen, i - map.get(currSum));
            } else {
                map.put(currSum, i);
            }
        }

        return maxLen;
    }
}