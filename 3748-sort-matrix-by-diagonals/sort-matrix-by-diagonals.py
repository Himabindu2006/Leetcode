from collections import defaultdict

class Solution:
    def sortMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)
        diagonals = defaultdict(list)

        # Step 1: Collect elements of each diagonal
        for i in range(n):
            for j in range(n):
                diagonals[i - j].append(grid[i][j])

        # Step 2: Sort diagonals based on region
        for d in diagonals:
            if d >= 0:  # bottom-left triangle (including main diagonal)
                diagonals[d].sort(reverse=True)  # non-increasing
            else:       # top-right triangle
                diagonals[d].sort()  # non-decreasing

        # Step 3: Place elements back into the grid
        for i in range(n):
            for j in range(n):
                grid[i][j] = diagonals[i - j].pop(0)

        return grid