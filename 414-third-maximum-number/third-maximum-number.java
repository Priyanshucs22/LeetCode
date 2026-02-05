class Solution {
    public int thirdMax(int[] nums) {
        long f = Long.MIN_VALUE;
        long s = Long.MIN_VALUE;
        long t = Long.MIN_VALUE;
        for(int e:nums){
            if(e>f){
                t = s;
                s = f;
                f = e;
            }
            else if(e>s && e!=f){
                t = s;
                s = e;
            }
            else if(e>t && e!=s && e!=f){
                t = e;
            }
        }
        return (int) (t == Long.MIN_VALUE?f:t);
    }
}