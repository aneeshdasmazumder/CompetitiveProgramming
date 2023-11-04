class Solution {
    public void rotate(int[][] matrix) {
        // int[][] tempM = new int[matrix.length][matrix[0].length];
        // for(int i=0; i<matrix.length; i++) {
        //     for(int j=0; j<matrix[i].length; j++) {
        //         tempM[i][j] = matrix[j][i];
        //     }
        // }

        

        // int row = 0, col = matrix[0].length-1;
        // for(int i=0; i<tempM.length; i++) {
        //     for(int j=0; j<tempM[i].length; j++) {
        //         matrix[row][col] = tempM[i][j];
        //         col--;
        //     }
        //     col = matrix[0].length-1;
        //     row++;
        // }
        int T=0, B=matrix.length-1, L=0, R=matrix[0].length-1;
        while (T<=B && L<=R) {
            for(int i=L; i<=R; i++) {
                int temp = matrix[T][i];
                matrix[T][i] = matrix[i][T];
                matrix[i][T] = temp;
            }
            T++;
            L++;
        }
        T=0; B=matrix.length-1; L=0; R=matrix[0].length-1;
        while (T<=B) {
            int i=L, j=R;
            while(i<j) {
                int temp = matrix[T][i];
                matrix[T][i] = matrix[T][j];
                matrix[T][j] = temp;
                i++; j--;
            }
            T++;
        }
        // for(int i=0; i<matrix.length; i++) {
        //     for(int j=0; j<matrix[i].length; j++) {
        //         System.out.print(tempM[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }
}