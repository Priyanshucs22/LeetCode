class Solution {
    public long countSubarrays(int[] nums, long k) {
        long sum = 0;
        long cnt = 0;
        int l = 0;
        for(int i=0;i<nums.length;i++){
            sum+=(long)nums[i];
            int len = i-l+1;
            while(sum*len>=k){
                sum-=nums[l++];
                len = i-l+1;
            }
            cnt+=len;
        }
        return cnt;
    }
}