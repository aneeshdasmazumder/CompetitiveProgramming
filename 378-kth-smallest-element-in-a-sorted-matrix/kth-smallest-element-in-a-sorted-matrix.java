class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int R = matrix.length;
        int C = matrix[0].length;
        int n = R*C;
        PriorityQueue<Integer> pq = new PriorityQueue<>(n, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        int num = n;
        int count = k;
        int row=0, col = 0;
        while(count > 0) {
            if(row < R && col < C) {
                pq.add(matrix[row][col]);
                col++;
            }

            if(col >= C) {
                row++;
                col = 0;
            }
            num--;
            count--;
        }

        while(num > 0) {
            if(row < R && col < C) {
                if(matrix[row][col] < pq.peek()) {
                    pq.poll();
                    pq.add(matrix[row][col]);
                }
                col++;
            }

            if(col >= C) {
                row++;
                col = 0;
            }
            num--;
        }

        // while(!pq.isEmpty()) {
        //     System.out.println(pq.poll());
        // }

        // for(int i=0; i<R; i++) {
        //     for(int j=0; j<C; j++) {
                
        //         pq.add(matrix[i][j]);
        //     }
        // }

        // int count = k;
        // int value = 0;
        // while(count > 0) {
        //     // System.out.println(pq.peek());
        //     value = pq.poll();
        //     count--;
        // }

        return pq.poll();
    }
}