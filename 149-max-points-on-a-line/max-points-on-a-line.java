import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;

        int maxPointsOnLine = 0;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            int samePoint = 1; // Count the anchor point itself
            int currMax = 0;

            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    samePoint++;
                } else {
                    int gcd = getGCD(dx, dy);
                    dx /= gcd;
                    dy /= gcd;

                    // Normalize slope sign
                    if (dx < 0) {
                        dx = -dx;
                        dy = -dy;
                    }

                    String slopeKey = dy + "/" + dx;
                    slopeCount.put(slopeKey, slopeCount.getOrDefault(slopeKey, 0) + 1);
                    currMax = Math.max(currMax, slopeCount.get(slopeKey));
                }
            }

            maxPointsOnLine = Math.max(maxPointsOnLine, currMax + samePoint);
        }

        return maxPointsOnLine;
    }

    // Helper to compute Greatest Common Divisor
    private int getGCD(int a, int b) {
        if (b == 0)
            return a;
        return getGCD(b, a % b);
    }
}
