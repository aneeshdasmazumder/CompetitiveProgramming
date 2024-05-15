class Solution {
    public void sortColors(int[] nums) {
        int i=nums.length - 1;
        int c = 2;
        while(i>=0 && c>=0) {
            for(int j=i; j>=0; j--) {
                if(nums[j]==c) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i--;
                }
            }
            c--;
        }
    }
}