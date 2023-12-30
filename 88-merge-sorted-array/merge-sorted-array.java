class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int idx = 0;
        int[] tempArr = new int[m+n];
        while(i<m && j<n) {
            if(nums1[i] < nums2[j]) {
                tempArr[idx] = nums1[i];
                i++;
                idx++;
            } else {
                tempArr[idx] = nums2[j];
                j++;
                idx++;
            }
        }
        while(i<m) {
            tempArr[idx] = nums1[i];
            i++;
            idx++;
        }

        while(j<n) {
            tempArr[idx] = nums2[j];
            j++;
            idx++;
        }

        for(int x=0; x<tempArr.length; x++) {
            nums1[x] = tempArr[x];
        }
    }
}