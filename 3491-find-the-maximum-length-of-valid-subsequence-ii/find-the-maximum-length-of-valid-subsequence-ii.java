import java.util.*;
class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer>[] dp = new Map[n];
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int mod = (nums[j] + nums[i]) % k;
                int len = dp[j].getOrDefault(mod, 1) + 1;
                dp[i].put(mod, Math.max(dp[i].getOrDefault(mod, 1),len));
                maxLen = Math.max(maxLen, dp[i].get(mod));
            }
        }
        return maxLen;
    }
}
