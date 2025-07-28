class Solution {
    int maxOr = 0;
    int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        // Step 1: Find the maximum OR value possible
        for (int num : nums) {
            maxOr |= num;
        }

        // Step 2: Backtrack to explore all subsets
        backtrack(nums, 0, 0);

        return count;
    }

    private void backtrack(int[] nums, int index, int currentOr) {
        if (index == nums.length) {
            // Don't count empty subset
            if (currentOr == maxOr) {
                count++;
            }
            return;
        }

        // Include nums[index] in OR
        backtrack(nums, index + 1, currentOr | nums[index]);

        // Exclude nums[index] from OR
        backtrack(nums, index + 1, currentOr);
    }
}
