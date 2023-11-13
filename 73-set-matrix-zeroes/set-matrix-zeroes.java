class Solution {
    public void setZeroes(int[][] matrix) {
        int col0 = 1;
        int row0 = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(i==0 && matrix[i][j] == 0) {
                    row0 = 0;
                }
                if(j==0 && matrix[i][j] == 0) {
                    col0 = 0;
                } else if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // System.out.print(n + " " + m);
        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                System.out.println(i + " " + j);
                if(i==0) {
                    if(row0 == 0) matrix[i][j] = 0;
                }
                if(j==0) {
                    if(col0 == 0) matrix[i][j] = 0;
                } else if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    System.out.println("i= "+i+ "j= "+j+" "+matrix[i][j]);
                    matrix[i][j] = 0;
                    System.out.println("--i= "+i+ "j= "+j+" "+matrix[i][j]);
                }
            }
            //System.out.println();
        } 

        // for(int i=0; i<matrix.length; i++) {
        //     for(int j=0; j<matrix[i].length; j++) {
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println();
        // } 
    }
}