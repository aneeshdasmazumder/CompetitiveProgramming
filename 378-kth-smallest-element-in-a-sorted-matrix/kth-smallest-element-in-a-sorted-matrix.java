class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int R = matrix.length;
        int C = matrix[0].length;
        int n = R*C;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                
                pq.add(matrix[i][j]);
            }
        }

        int count = k;
        int value = 0;
        while(count > 0) {
            // System.out.println(pq.peek());
            value = pq.poll();
            count--;
        }

        return value;
    }
}