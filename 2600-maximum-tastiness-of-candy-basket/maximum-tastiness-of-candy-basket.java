class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int l = 0;
        int h = price[price.length-1] - price[0];
        int ans = 0;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(can(mid,k,price)){
                ans = mid;
                l=mid+1;
            }else{
                h = mid-1;
            }
        }
        return ans;
    }
    boolean can(int mid,int k,int[] price){
        int cnt = 1;
        int last = price[0];
        for(int i=1;i<price.length;i++){
            if(price[i] - last >= mid){
                cnt++;
                last = price[i];
            }
            if(cnt>=k) return true;
        }
        return false;
    }
}