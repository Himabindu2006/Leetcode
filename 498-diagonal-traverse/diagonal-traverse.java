class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        
        int r = 0, c = 0;
        for (int i = 0; i < m * n; i++) {
            res[i] = mat[r][c];
            
            // direction depends on (r + c) parity
            if ((r + c) % 2 == 0) { // moving up-right
                if (c == n - 1) { // last column
                    r++;
                } else if (r == 0) { // first row
                    c++;
                } else { 
                    r--; 
                    c++; 
                }
            } else { // moving down-left
                if (r == m - 1) { // last row
                    c++;
                } else if (c == 0) { // first column
                    r++;
                } else { 
                    r++; 
                    c--; 
                }
            }
        }
        
        return res;
    }
}