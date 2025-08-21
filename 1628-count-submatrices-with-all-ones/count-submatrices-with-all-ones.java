class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] height = new int[m][n];

        // Build height matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    height[i][j] = (i == 0 ? 1 : height[i - 1][j] + 1);
                }
            }
        }

        int count = 0;

        // For each row, calculate contribution
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (height[i][j] > 0) {
                    int minHeight = height[i][j];
                    // Expand leftwards
                    for (int k = j; k >= 0 && height[i][k] > 0; k--) {
                        minHeight = Math.min(minHeight, height[i][k]);
                        count += minHeight;
                    }
                }
            }
        }

        return count;
    }
}