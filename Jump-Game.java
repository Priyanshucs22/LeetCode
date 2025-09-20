class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return find(nums,0,dp);
    }
    public static boolean find(int[] nums,int i,Boolean[] dp){
        if(i >= nums.length-1) return true;
        if(dp[i]!=null) return dp[i];
        for(int k=1;k<=nums[i];k++){
            if(find(nums,i+k,dp)) return true;
        }
        return dp[i] = false;
    }
}