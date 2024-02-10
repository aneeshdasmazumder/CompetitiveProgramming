class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Index> rottenQ = new LinkedList<>();
        int R = grid.length;
        int C = grid[R-1].length;
        int timer = 0;
        int freshOrangeCount = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 2) {
                    Index idx = new Index(i,j);
                    rottenQ.offer(idx);
                }

                if(grid[i][j] == 1) {
                    freshOrangeCount++;
                }
            }
        }

        if(freshOrangeCount == 0) return 0;
        
        while(!rottenQ.isEmpty()) {
            int size = rottenQ.size();
            // System.out.println(size);
            
            // System.out.println(rottenQ.peek().row + " " + rottenQ.peek().col);
            while(size > 0) {
                Index idx = rottenQ.poll();
                int row = idx.row;
                int col = idx.col;
                // System.out.println(row + " " + col);
                int r = row-1;
                int c = col;
                
                // upward
                if(r<R && c<C && r>=0 && c>=0 && grid[r][c] == 1) {
                    grid[r][c] = 2;
                    rottenQ.offer(new Index(r, c));
                    freshOrangeCount--;
                    // System.out.println("1-2: "+a.get(1).get(2) + " up ");
                }

                // downward
                r = row+1;
                c = col;
                // System.out.println(a.get(1).get(2));
                if(r<R && c<C && r>=0 && c>=0 && grid[r][c] == 1) {
                    
                    grid[r][c]=2;
                    // System.out.println("1-2: "+a.get(1).get(2) + " down " + r + " " + c);
                    rottenQ.offer(new Index(r, c));
                    freshOrangeCount--;
                    
                }

                // leftward
                r = row;
                c = col-1;
                if(r<R && c<C && r>=0 && c>=0 && grid[r][c] == 1) {
                    grid[r][c]=2;
                    rottenQ.offer(new Index(r, c));
                    freshOrangeCount--;
                    // System.out.println("1-2: "+a.get(1).get(2) + " left ");
                }

                // rightward
                r = row;
                c = col+1;
                if(r<R && c<C && r>=0 && c>=0 && grid[r][c] == 1) {
                    // System.out.println("------");
                    grid[r][c]=2;
                    rottenQ.offer(new Index(r, c));
                    freshOrangeCount--;
                    // System.out.println("1-2: "+a.get(1).get(2) + " right ");
                }
                // System.out.println(rottenQ.size());
                // System.out.println("1-2: "+a.get(1).get(2) + " " + row + " " + col);
                size--;
            }

            timer++;
        }
        // System.out.println(a.get(1).get(2));
        if(freshOrangeCount > 0) return -1;
        return timer-1;
    }
}

class Index {
    int row;
    int col;
    Index(int row, int col) {
        this.row = row;
        this.col = col;
    }
}