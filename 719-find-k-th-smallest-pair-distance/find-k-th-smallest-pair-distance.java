class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int h = nums[nums.length-1] - nums[0];
        int ans= 0;
        while(l<=h){
            int mid = l + (h - l)/2;
            if(can(mid,nums,k)){
                ans = mid;
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    boolean can(int mid, int[] nums, int k){
        int cnt = 0;
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            while(j < nums.length && nums[j] - nums[i] <= mid){
                j++;
            }
            cnt += (j - i - 1);
            if(cnt >= k) return true;
        }
        return false;
    }
}