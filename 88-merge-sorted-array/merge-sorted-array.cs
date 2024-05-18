public class Solution {
    public void Merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) return;
        int nums1Len = nums1.Length-1;
        int nums1Idx = nums1Len - n;
        int nums2Idx = n-1;
        while(nums2Idx >= 0 && nums1Idx >= 0) {
            if(nums1[nums1Idx] <= nums2[nums2Idx]) {
                nums1[nums1Len] = nums2[nums2Idx];
                nums1Len--;
                nums2Idx--;
            } else {
                nums1[nums1Len] = nums1[nums1Idx];
                nums1[nums1Idx] = 0;
                nums1Idx--;
                nums1Len--;
            }
        }

        while(nums2Idx >= 0) {
            nums1[nums1Len] = nums2[nums2Idx];
            nums2Idx--;
            nums1Len--;
        }
    }
}