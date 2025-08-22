class Solution {
    public int minimumArea(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int minRow = rows, maxRow = -1;
        int minCol = cols, maxCol = -1;
        
        // Traverse the grid to find bounds of 1's
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        
        // If no 1s found, area is 0
        if (maxRow == -1) return 0;
        
        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }
}
