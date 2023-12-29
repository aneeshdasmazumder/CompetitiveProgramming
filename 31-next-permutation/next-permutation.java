class Solution {

    public int[] swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        return nums;
    }

    public void reverse(int[] nums, int i) {
        int mid = ((nums.length-1) - i)/2;
        int left = i;
        int right = nums.length - 1;

        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++; right--;
        }
        
    }

    public void nextPermutation(int[] nums) {
        // 1431
        int i = nums.length - 1;
        while(i>=1 && nums[i-1] >= nums[i]) {
            i--;
        }
        if(i >= 1) {
            int smallerNum = i-1;
            int nextGreater = i;
            while(i < nums.length && nums[smallerNum] < nums[i]) {
                nextGreater = i;
                i++;
            }

            nums = swap(smallerNum, nextGreater, nums);

            reverse(nums, smallerNum+1);
        } else {
            reverse(nums, i);
        }
        
    }
}