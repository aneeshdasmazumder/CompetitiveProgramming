class KthLargest {
    private int k;
    private int[] nums;
    
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        if(this.nums.length > 0) {
            int i=0;
            for(; i<this.k; i++) {
                if(i < this.nums.length)
                    pq.add(this.nums[i]);
                else
                    pq.add(Integer.MIN_VALUE);
            }
                

            while(i < this.nums.length) {
                if(pq.peek() <= this.nums[i]) {
                    pq.poll();
                    pq.add(this.nums[i]);
                }
                i++;
            }
        } else {
            pq.add(Integer.MIN_VALUE);
        }
        
    }
    
    public int add(int val) {
        if(pq.peek() != null && pq.peek() <= val) {
            pq.poll();
            pq.add(val);
        }
        return pq.peek() != null ? pq.peek() : 0;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */