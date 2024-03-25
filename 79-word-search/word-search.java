class Solution {
    public boolean exist(char[][] board, String word) {
        for(int row=0; row< board.length; row++) {
            for(int col =0; col < board[row].length; col++) {
                if(isWordExist(board, word, row, col, 0)) return true;
            }
        }
        return false;
    }

    public boolean isWordExist(char[][] board, String word, int row, int col, int idx) {

        if(idx == word.length()) return true;

        if(row < 0 || col < 0 || row >= board.length || col >= board[row].length) return false;

        if(board[row][col] == word.charAt(idx)) {
            board[row][col] = '#';
            // Top
            if(isWordExist(board, word, row-1, col, idx+1)) return true;

            // Right
            if(isWordExist(board, word, row, col+1, idx+1)) return true;

            // Left
            if(isWordExist(board, word, row, col-1, idx+1)) return true;

            // Bottom
            if(isWordExist(board, word, row+1, col, idx+1)) return true;

            board[row][col] = word.charAt(idx);
        }

        return false;
    }
}

// Time Complexity - O(4^n) exponentially