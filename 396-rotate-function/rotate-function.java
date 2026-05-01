class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int rotationSum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            rotationSum += nums[i] * i;
        }
        int max = rotationSum;
        for (int i = 1; i < n; i++) {
            rotationSum += sum - n * nums[n - i];
            max = Math.max(max, rotationSum);
        }
        return max;
    }
}
