class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 1 && nums[0] == 1) return 2;
        for(int i=0; i<nums.length; i++) {

            while(nums[i]-1 != i && nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
            System.out.println(nums[i]);
        }

        int val = Integer.MAX_VALUE;

        int count = 1;
        int idx = 0;
        boolean isSame = false;
        while(idx < nums.length && nums[idx] == count) {
            idx++;
            count++;
        }
        // while(idx < nums.length && (nums[idx] == count || nums[idx] == nums.length)) {
        //     if(nums[idx] == count) count++;
        //     idx++;
            
        // }
        // while(idx < nums.length) {
        //     if(idx != nums[idx]) {
        //         if(nums[idx] < val) val = nums[idx];
        //         count++;
        //     } else {
        //         count++;
        //     }
        //     idx++;
        // }
        // if(val == nums.length) {
        //     return count+1;
        // } else return count;
        // if(i != nums[i]) {}
        // if(count == nums.length)
            return count;
        // else return count;
    }
}