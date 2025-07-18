import java.util.*;
class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int len = nums.length;
        long[] leftSum = new long[len];
        long[] rightSum = new long[len];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int i = 0; i < 2 * n; i++) {
            sum += nums[i];
            maxHeap.offer(nums[i]);
            if (maxHeap.size() > n) {
                sum -= maxHeap.poll();  
            }
            if (maxHeap.size() == n) {
                leftSum[i] = sum;
            }
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        sum = 0;
        for (int i = len - 1; i >= n; i--) {
            sum += nums[i];
            minHeap.offer(nums[i]);
            if (minHeap.size() > n) {
                sum -= minHeap.poll();  
            }
            if (minHeap.size() == n) {
                rightSum[i] = sum;
            }
        }
        long res = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            res = Math.min(res, leftSum[i] - rightSum[i + 1]);
        }
        return res;
    }
}
