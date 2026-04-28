class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int l = 0;
        int h = nums[nums.length-1] - nums[0];
        int ans = 0;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(can(mid,nums,p)){
                ans = mid;
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return ans;
    }
    boolean can(int mid,int[] nums,int p){
        int cnt = 0;
        for(int i=1;i<nums.length;i++){
            int n = nums[i];
            int pre = nums[i-1];
            if(n-pre <= mid){
                cnt++;
                i++;
            }
            if(cnt>=p) return true;
        }
        return false;
    }
}