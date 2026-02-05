class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] re = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int idx = (nums[i] + i) % nums.length;
            if (idx < 0) { 
                idx += nums.length;
            }
            re[i] = nums[idx];
        }
        return re;
    }
}
