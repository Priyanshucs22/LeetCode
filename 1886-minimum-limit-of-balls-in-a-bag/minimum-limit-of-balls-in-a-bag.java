class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1;
        int h = 0;
        
        for (int val : nums)
            h = Math.max(h, val);

        int ans = 0;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (can(mid, nums, maxOperations)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    boolean can(int mid, int[] nums, int op) {
        long total = 0;

        for (int x : nums) {
            total += (x - 1) / mid;
        }

        return total <= op;
    }
}