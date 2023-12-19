class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        // Max from left
        leftMax[0] = height[0];
        for(int i=1; i<height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        // Max from right
        rightMax[height.length-1] = height[height.length - 1];
        for(int i=height.length - 2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int maxArea = 0;

        for(int i=0; i<height.length; i++) {
            maxArea += (Math.min(leftMax[i], rightMax[i]) - height[i]);
            // System.out.println(leftMax[i] + " + " + rightMax[i] + " = " + maxArea);
        }

        return maxArea;
    }
}