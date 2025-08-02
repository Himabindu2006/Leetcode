import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> count1 = new HashMap<>();
        Map<Integer, Integer> count2 = new HashMap<>();
        Map<Integer, Integer> totalCount = new HashMap<>();
        
        for (int val : basket1) {
            count1.put(val, count1.getOrDefault(val, 0) + 1);
            totalCount.put(val, totalCount.getOrDefault(val, 0) + 1);
        }
        for (int val : basket2) {
            count2.put(val, count2.getOrDefault(val, 0) + 1);
            totalCount.put(val, totalCount.getOrDefault(val, 0) + 1);
        }
        
        // Check if it's possible
        for (int val : totalCount.keySet()) {
            if (totalCount.get(val) % 2 != 0) return -1;
        }

        List<Integer> extra1 = new ArrayList<>();
        List<Integer> extra2 = new ArrayList<>();
        
        for (int val : totalCount.keySet()) {
            int target = totalCount.get(val) / 2;
            int diff1 = count1.getOrDefault(val, 0) - target;
            if (diff1 > 0) {
                for (int i = 0; i < diff1; i++) {
                    extra1.add(val);
                }
            } else if (diff1 < 0) {
                for (int i = 0; i < -diff1; i++) {
                    extra2.add(val);
                }
            }
        }

        Collections.sort(extra1);
        extra2.sort(Collections.reverseOrder());
        
        int minValue = Integer.MAX_VALUE;
        for (int val : basket1) minValue = Math.min(minValue, val);
        for (int val : basket2) minValue = Math.min(minValue, val);

        long cost = 0;
        for (int i = 0; i < extra1.size(); i++) {
            int a = extra1.get(i);
            int b = extra2.get(i);
            cost += Math.min(2 * (long)minValue, Math.min(a, b));
        }

        return cost;
    }
}
