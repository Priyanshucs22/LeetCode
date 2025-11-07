class Solution {
    public int longestNiceSubarray(int[] nums) {
        int len = 0;
        int l = 0;
        int and = 0;
        for(int i=0;i<nums.length;i++){
            while((and&nums[i])!=0){
                and-=nums[l];
                l++;
            }
            and += nums[i];
            len = Math.max(len,i-l+1);
        }
        return len;
    }
}