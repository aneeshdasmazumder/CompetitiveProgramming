public class Solution {
    public void NextPermutation(int[] nums) {
        int i = nums.Length -1;
        int n = i;
        while(i >= 1 && nums[i] <= nums[i-1]) {
            i--;
        }
        
        if(i >=1) {
            int smallNum = i-1;
            int nextGreater = i;
            while(i < nums.Length && nums[smallNum] < nums[i]) {
                nextGreater = i;
                i++;
            }
            
            swap(smallNum, nextGreater, nums);
            
            reverse(smallNum + 1, nums.Length - 1, nums);
        } else reverse(i, nums.Length - 1, nums);
        
    }

    public void swap(int left, int right, int[] nums) {
        
        int _temp = nums[left];
        nums[left] = nums[right];
        nums[right] = _temp;
        
    }

    public void reverse(int left, int right, int[] nums) {
        Console.WriteLine(nums[left] + " " + nums[right]);
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            Console.WriteLine(nums[left] + " " + nums[right]);
            left++; right--;
        }
    }
}