class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for(int i=2;i<nums.length;i++){
            if(nums[i-1]+nums[i-2] <= nums[i]){
                continue;
            }
            else{
                max =Math.max(nums[i-1]+nums[i-2]+nums[i],max);
            }
        }
        return max;
    }
}