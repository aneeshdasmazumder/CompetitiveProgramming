class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int leftProduct = 1;
        int rightProduct = 1;
        int i = 0;
        int j = nums.length - 1;
        while(i < nums.length) {
            leftProduct = leftProduct * nums[i];
            rightProduct = rightProduct * nums[j];
            max = Math.max(max, Math.max(leftProduct, rightProduct));
            if(leftProduct == 0) leftProduct = 1;
            if(rightProduct == 0) rightProduct = 1;
            i++; j--;
        }

        return max;
    }
}