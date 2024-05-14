public class Solution {
    public int MaxArea(int[] height) {
        int left = 0;
        int right = height.Length-1;
        int maxArea = 0;
        int area = 0;

        while(left < right) {
            if(height[left] < height[right]) {
                area = height[left] * (right - left);
                left++;
            } else {
                area = height[right] * (right - left);
                right--;
            }

            maxArea = Math.Max(maxArea, area);
            
        }

        return maxArea;
    }
}