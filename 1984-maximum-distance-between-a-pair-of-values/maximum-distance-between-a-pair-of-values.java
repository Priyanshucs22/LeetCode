class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxd = 0;
        for(int i=0;i<nums1.length;i++){
            int a = 0;
            int b = nums2.length-1;
            while(b>=a){
                int mid = (b+a)/2;
                if(mid >= i && nums2[mid] >= nums1[i]){
                    maxd = Math.max(maxd,mid-i);
                    a = mid+1;
                }
                else if(nums2[mid] <  nums1[i]){
                    b = mid-1;
                }
                else a = mid + 1;
            }
        }
        return maxd;
    }
}