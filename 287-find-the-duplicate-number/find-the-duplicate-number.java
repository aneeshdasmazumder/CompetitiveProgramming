class Solution {
    public int findDuplicate(int[] nums) {
        // for(int i=0; i<nums.length; i++) {
        //     int idx = Math.abs(nums[i]);
        //     if(nums[idx] >= 0) {
        //         nums[idx] = -nums[idx];
        //     } else {
        //         return idx;
        //     }
        // }

        int slow = 0;
        int fast = 0;
        int idx = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
            // System.out.println(slow + " " + fast);
        } while(slow != fast);
        
        slow = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}