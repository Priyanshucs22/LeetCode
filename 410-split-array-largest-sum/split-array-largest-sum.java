class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int h = 0;
        for(int e:nums){
            l = Math.max(l,e);
            h +=e;
        }
        int ans = 0;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(can(mid,nums,k)){
                ans = mid;
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return ans;
    }
    boolean can(int mid,int[] nums,int k){
        int cnt =1;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(sum + nums[i] <=mid){
                sum+=nums[i];
            }else{
                cnt++;
                sum = nums[i];
            }
        }
        return cnt<=k;
    }
}