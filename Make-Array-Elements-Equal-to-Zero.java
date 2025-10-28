class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (isValid(nums.clone(), i, -1)) c++; 
                if (isValid(nums.clone(), i, 1)) c++;  
            }
        }
        return c;
    }
    private boolean isValid(int[] nums, int curr, int direction) {
        int n = nums.length;
        while (curr >= 0 && curr < n) {
            if (nums[curr] == 0) {
                curr += direction;
            } else if (nums[curr] > 0) {
                nums[curr]--;
                direction = -direction;
                curr += direction;
            }
        }
        for (int num : nums) {
            if (num != 0) return false;
        }
        return true;
    }
}