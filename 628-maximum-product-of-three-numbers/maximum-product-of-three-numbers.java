class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int a = nums[size-1] * nums[size-2] * nums[size-3];
        int b = nums[0] * nums[1] * nums[size-1];
        return Math.max(a,b);
    }
}