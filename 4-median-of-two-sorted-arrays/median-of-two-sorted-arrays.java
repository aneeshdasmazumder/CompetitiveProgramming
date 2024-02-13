class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] resultArr = new int[nums1.length+nums2.length];
        int i = 0;
        int idx1 = 0;
        int idx2 = 0;
        while(idx1 < nums1.length && idx2 < nums2.length) {
            if(nums1[idx1] <= nums2[idx2]) {
                resultArr[i] = nums1[idx1];
                idx1++;
            } else {
                resultArr[i] = nums2[idx2];
                idx2++;
            }
            
            i++;
        }

        while(idx1 < nums1.length) {
            resultArr[i] = nums1[idx1];
            idx1++;
            i++;
        }

        while(idx2 < nums2.length) {
            resultArr[i] = nums2[idx2];
            idx2++;
            i++;
        }

        int medIdx = resultArr.length / 2;
        double result;
        if(resultArr.length % 2 == 0) {
            double num = resultArr[medIdx-1] + resultArr[medIdx];
            result = num / 2;
        } else {
            result = resultArr[medIdx];
        }

        return result;
    }
}