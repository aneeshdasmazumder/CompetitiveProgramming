class Solution {
    static boolean searchInSorted(int arr[], int k) {
        // Your code here
        if(arr[0] == k) return true;
        int start = 0;
        int end = arr.length - 1;
        
        return getTargetValue(arr, start, end, k);
    }
    
    static boolean getTargetValue(int[] nums, int start, int end, int target) {
        if(start > end || end < start) return false;
        int mid = (start + end) / 2;
        
        if(nums[mid] == target) return true;
        else if(nums[mid] < target) {
            return getTargetValue(nums, mid+1, end, target);
        } else if(nums[mid] > target) {
            return getTargetValue(nums, start, mid-1, target);
        } else return false;
        
    }
}