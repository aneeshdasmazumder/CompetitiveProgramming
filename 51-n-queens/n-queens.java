class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        boolean[][] chess = new boolean[n][n];

        nQueens(0, chess, result, n);

        return result;
    }

    public void nQueens(int row, boolean[][] chess, List<List<String>> result, int n) {
        if(row == n) {
            List<String> temp = new ArrayList<>();
            for(int i=0; i<n; i++) {
                String res = "";
                for(int j=0; j<n; j++) {
                    if(chess[i][j]) res += 'Q';
                    else res += '.';
                }

                temp.add(res);
            }

            result.add(temp);
        }

        for(int col =0; col<n; col++) {
            if(isQueenSafe(row, col, chess, n)) {
                chess[row][col] = true;
                nQueens(row+1, chess, result, n);
                chess[row][col] = false;
            }
        }
    }

    public boolean isQueenSafe(int row, int col, boolean[][] chess, int n) {
        // check up
        for(int i=row-1; i>=0; i--) {
            if(chess[i][col] == true) return false;
        }
        // check left diagonal upward
        int irow = row-1;
        int icol = col-1;
        while(irow >=0 && icol >= 0) {
            if(chess[irow][icol] == true) return false;
            irow--; icol--;
        }

        // while(irow >= 0) {
        //     if(chess[irow][icol] == true) return false;
        //     irow--;
        // }

        // while(icol >= 0) {
        //     if(chess[irow][icol] == true) return false;
        //     icol--;
        // }

        // check right diagonal upward

        int jrow = row-1;
        int jcol = col+1;
        while(jrow >= 0 && jcol >= 0 && jcol < n) {
            if(chess[jrow][jcol] == true) return false;
            jrow--; jcol++;
        }

        // while(jrow > 0 && jrow < n) {
        //     if(chess[jrow][jcol] == true) return false;
        //     jrow++;
        // }

        // while(jcol > 0 && jcol < n) {
        //     if(chess[jrow][jcol] == true) return false;
        //     jcol++;
        // }

        return true;
    }
}