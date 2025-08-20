class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long cnt = 0, zero = 0;
        for (int e : nums) {
            zero = (e == 0) ? zero + 1 : 0;
            cnt += zero;
        }
        return cnt;
    }
}