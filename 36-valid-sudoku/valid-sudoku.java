class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Use sets/arrays to track digits seen
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                
                if (ch == '.') continue; // skip empty cells
                
                int num = ch - '1'; // convert char '1'-'9' to index 0-8
                int boxIndex = (r / 3) * 3 + (c / 3); // sub-box index 0-8
                
                // Check row, col, box
                if (rows[r][num] || cols[c][num] || boxes[boxIndex][num]) {
                    return false; // already seen → invalid
                }
                
                // Mark as seen
                rows[r][num] = true;
                cols[c][num] = true;
                boxes[boxIndex][num] = true;
            }
        }
        
        return true; // valid if no conflicts
    }
}
