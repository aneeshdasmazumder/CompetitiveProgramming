class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            // Cases to check
            // 1. Arrange the values in the loop according to given value array based index
            // 2. Check only if...
            //  2.1> ith value - 1 is not equal to i
            //  2.2> ith value is withing the range of 0 to n
            //  2.3> current index value is not equal to the value in the already present index
            while(nums[i]-1 != i && nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
            // System.out.println(nums[i]);
        }

        int count = 1;
        int idx = 0;
        while(idx < nums.length && nums[idx] == count) {
            idx++;
            count++;
        }
            return count;
    }
}