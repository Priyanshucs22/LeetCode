class Solution {
    public int mirrorDistance(int n) {
        int m = reverse(n);
        return Math.abs(m-n);
    }
    static int reverse(int n){
        int a = 0;
        while(n!=0){
            a = a*10 + (n%10);
            n = n/10;
        }
        return a;
    }
}