class MedianFinder {

    PriorityQueue<Integer> pqLeft = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> pqRight = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(pqLeft.isEmpty()) {
            pqLeft.add(num);
        } else if(pqLeft.size() == pqRight.size()) {
            if(num < pqRight.peek()) 
                pqLeft.add(num);
            else {
                pqLeft.add(pqRight.poll());
                pqRight.add(num);
            }
        } else if(pqRight.size() < pqLeft.size()) {
            if(pqLeft.peek() > num) {
                pqRight.add(pqLeft.poll());
                pqLeft.add(num);
            } else pqRight.add(num);
        }
            
    }
    
    public double findMedian() {
        double left = 0.00;
        double right = 0.00;
        double med = 0.00;
        if(pqLeft.size() == pqRight.size()) {
            left = pqLeft.peek();
            right = pqRight.peek();
            med = (left+right)/2;
        } else {
            med = pqLeft.peek();
        }
        return med;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */