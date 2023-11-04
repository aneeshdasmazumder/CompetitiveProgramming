class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int T = 0, L = 0, B = matrix.length - 1, R = matrix[0].length - 1;

        while (L <= R && T <= B) {
            // Left -> right
            if(L <= R) {
                for(int i=L; i<=R; i++) 
                    list.add(matrix[T][i]);
            } else return list;
            System.out.println(list);
            T++;

            // Top -> Bottom
            if(T <= B) {
                for(int i=T; i<=B; i++) 
                    list.add(matrix[i][R]);
            } else return list;
            R--;

            // Right -> Left
            if(L<=R) {
                for(int i=R; i>=L; i--)
                    list.add(matrix[B][i]);
            } else return list;
            
            B--;

            // Bottom -> Top
            if(T<=B) {
                for(int i=B; i>=T; i--) 
                    list.add(matrix[i][L]);
            } else return list;
            
            L++;
        }

        

        return list;
    }
}