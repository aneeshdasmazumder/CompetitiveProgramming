class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i=0;
        for(; i<k; i++)
            pq.add(nums[i]);

        while(i < nums.length) {
            if(pq.peek() < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
            i++;
        }

        return pq.peek();
    }
}