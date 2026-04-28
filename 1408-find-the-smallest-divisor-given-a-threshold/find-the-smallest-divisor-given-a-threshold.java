class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int h = 0;
        for(int e:nums){
            h = Math.max(e,h);
        }
        int ans = 0;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(can(mid,nums,threshold)){
                ans = mid;
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    boolean can(int mid,int[] nums,int th){
        int sum = 0;
        for(int e:nums){
            sum += (e + mid - 1)/mid;
        }
        return sum<=th;
    }
}