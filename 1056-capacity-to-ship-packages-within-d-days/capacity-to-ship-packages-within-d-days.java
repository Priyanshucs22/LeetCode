class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;
        for(int e:weights){
            r+=e;
            l = Math.max(e,l);
        }
        int ans = 0;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(can(mid,days,weights)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    boolean can(int mid,int days,int[] weights){
        int cnt = 1;
        int sum = 0;
        for(int e:weights){
            if(sum + e <= mid){
                sum+=e;
            }else{
                cnt++;
                sum = e;
            }
        }
        return cnt<=days;
    }
}