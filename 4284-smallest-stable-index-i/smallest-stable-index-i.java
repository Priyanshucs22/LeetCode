class Solution {
    public int firstStableIndex(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            int max = 0;
            int min = Integer.MAX_VALUE;
            for(int j=0;j<=i;j++){
                max = Math.max(nums[j],max);
            }
            for(int j=i;j<nums.length;j++){
                min = Math.min(nums[j],min);
            }
            int val = max-min;
            if(val <= k){
                return i;
            }
        }
        return -1;
    }
}