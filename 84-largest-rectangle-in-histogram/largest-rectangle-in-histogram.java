class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> stk = new Stack<>();
        int[] prev = new int[heights.length];
        int[] next = new int[heights.length];
        int maxArea = 0;
        // Loop over the array
        for(int i=0; i<heights.length; i++) {
            // find the prev smallest element and store the index in an array
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }
            if(stk.isEmpty()) {
                prev[i] = -1;
                stk.push(i);
            } else {
                prev[i] = stk.peek();
                stk.push(i);
            }
        }
        stk.clear();

        for(int i=heights.length-1; i>=0; i--) {
            // find next smallest element and store the index in an array
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }
            if(stk.isEmpty()) {
                next[i] = heights.length;
                stk.push(i);
            } else {
                next[i] = stk.peek();
                stk.push(i);
            }
            int area = ((next[i] - prev[i] - 1) * heights[i]);
            maxArea = Math.max(maxArea, area);
        }
            
        return maxArea;     
    }
}