class Solution {
    public void rotate(int[][] matrix) {
        int[][] tempM = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                tempM[i][j] = matrix[j][i];
            }
        }

        

        int row = 0, col = matrix[0].length-1;
        for(int i=0; i<tempM.length; i++) {
            for(int j=0; j<tempM[i].length; j++) {
                matrix[row][col] = tempM[i][j];
                col--;
            }
            col = matrix[0].length-1;
            row++;
        }
        // for(int i=0; i<matrix.length; i++) {
        //     for(int j=0; j<matrix[i].length; j++) {
        //         System.out.print(tempM[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }
}