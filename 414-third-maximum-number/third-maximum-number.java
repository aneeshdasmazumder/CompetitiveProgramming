class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[nums.length - 1];
        int count = 1;
        int index = nums.length - 2;

        while(count !=3 && index >=0) {
            if(nums[index] != prev) {
                prev = nums[index];
                count++;
            }

            index--;
        }
        if(count < 3) return nums[nums.length - 1];
        else return prev;
    }
}