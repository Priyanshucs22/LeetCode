class Solution {
    private static boolean isIncreasing(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] >= nums[i + 1]) return false;
        }
        return true;
    }
    private static boolean isDecreasing(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] <= nums[i + 1]) return false;
        }
        return true;
    }
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        for (int p = 1; p < n - 2; p++) {
            if (!isIncreasing(nums, 0, p)) continue;
            for (int q = p + 1; q < n - 1; q++) {
                if (!isDecreasing(nums, p, q)) continue;
                if (isIncreasing(nums, q, n - 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}