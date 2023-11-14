class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        for(; i<nums.length; i++) {
            if(i != nums[i]) return i;
        }

        return i;
    }
}